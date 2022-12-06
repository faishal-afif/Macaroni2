package com.example.macaroni.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.macaroni.database.Dummy
import com.example.macaroni.database.Menu
import com.example.macaroni.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_menu.*

class MainActivity : BaseSearchActivity() {
    private lateinit var binding: ActivityMainBinding

    private fun createButtonClickObservable(): Observable<String> {
        return Observable.create { emitter ->
            searchButton.setOnClickListener {
                emitter.onNext(queryEditText.text.toString())
            }
            emitter.setCancellable {
                searchButton.setOnClickListener(null)
            }
        }
    }
 //
    @SuppressLint("CheckResult")
    override fun onStart() {
        super.onStart()

        val searchTextObservable = createButtonClickObservable()

        searchTextObservable
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { showProgress() }
            .observeOn(Schedulers.io())
            .map { menuSearchEngine.search(it) ?: "" }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                // 3
                hideProgress()
                showResult(it as List<Menu>)
            }
    }

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

}