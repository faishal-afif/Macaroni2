package com.example.macaroni.database

object Dummy {

    var MENUS = arrayOf("Makaroni Goreng", "Makaroni Ngembang", "Makaroni Uril", "Makaroni Bantet",
        "Mie Kremes", "Keripik Cireng", "Mie Lidi", "Kerupuk Usus", "Basreng", "Keripik Singkong")

    fun getAllNotes() = listOf(
        Menu(
            id = 1,
            title = "Makaroni Goreng",
            price = "Rp7.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh."
        ),
        Menu(
            id = 2,
            title = "Makaroni Ngembang",
            price = "Rp7.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh. "
        ),
        Menu(
            id = 3,
            title = "Makaroni Uril",
            price = "Rp7.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh. "
        ),
        Menu(
            id = 4,
            title = "Makaroni Bantet",
            price = "Rp7.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh. "
        ),
        Menu(
            id = 5,
            title = "Mie Kremes",
            price = "Rp7.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh. "
        ),
        Menu(
            id = 6,
            title = "Keripik Cireng",
            price = "Rp8.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh."
        ),
        Menu(
            id = 7,
            title = "Mie Lidi",
            price = "Rp9.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh. "
        ),
        Menu(
            id = 8,
            title = "Kerupuk Usus",
            price = "Rp9.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh. "
        ),
        Menu(
            id = 9,
            title = "Basreng",
            price = "Rp8.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh. "
        ),
        Menu(
            id = 10,
            title = "Keripik Singkong",
            price = "Rp10.000",
            description = "Siapa yang gak tahu makanan ringan favorite masa kini. Makakan Makaroni kering ini digemari anak-anak dan orang dewasa. Macaroni Cuck menyajikan makaroni dengan bumbu rumahan yang lezat. Dan pastinya makaroni ini fresh karena produk homemade yang setiap harinya akan dihidangkan dengan fresh. "
        )
    )

     fun getDetailNote(id: Long) = getAllNotes().first { it.id == id }
}