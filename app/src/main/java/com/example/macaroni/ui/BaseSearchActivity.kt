package com.example.macaroni.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.macaroni.R
import com.example.macaroni.database.Dummy
import com.example.macaroni.database.Menu
import com.example.macaroni.database.MenuDatabase
import com.example.macaroni.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_menu.*

abstract class BaseSearchActivity : AppCompatActivity() {

    protected lateinit var menuSearchEngine: MenuSearchEngine
    private val menuAdapter = MenuAdapter()
    private val compositeDisposable = CompositeDisposable()
    private lateinit var binding: ActivityMainBinding


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val menuAdapter = MenuAdapter()
//        binding.rvNotes.apply {
//            adapter = menuAdapter
//            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
//        }
//
//        menuAdapter.menuList(Dummy.getAllNotes())
//
//        binding.fabAdd.setOnClickListener {
////            val intent = Intent(this, NewNoteActivity::class.java)
////            startActivity(intent)
//            Toast.makeText(this, "Fitur belum dibuat!", Toast.LENGTH_SHORT).show()
//        }
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        list.adapter = menuAdapter

        menuSearchEngine = MenuSearchEngine(this@BaseSearchActivity)

        val initialLoadDisposable = loadInitialData(this@BaseSearchActivity).subscribe()
        compositeDisposable.add(initialLoadDisposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        MenuDatabase.destroyInstance()
        compositeDisposable.clear()
    }

    protected fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    protected fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    protected fun showResult(result: List<Menu>) {
        if (result.isEmpty()) {
            Toast.makeText(this, "Menu tidak dapat ditemukan", Toast.LENGTH_SHORT).show()
        }
        menuAdapter.menus = result
    }

    private fun loadInitialData(context: Context): Flowable<List<Int>> {
        return Maybe.fromAction<List<Int>> {

            val database = MenuDatabase.getInstance(context = context).menuDao()

            val menuList = arrayListOf<Menu>()
            for (menu in Dummy.MENUS) {
                menuList.add(Menu(title = menu, price = menu, description = menu))
            }
            database.insertAll(menuList)

        }.toFlowable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                Toast.makeText(context, "Menu Berhasil Dipilih", Toast.LENGTH_LONG).show()
            }
            .doOnError {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }
    }
}