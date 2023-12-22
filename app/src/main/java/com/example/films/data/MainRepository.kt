package com.example.films.data

import com.example.films.domain.Film
import com.example.films.R

class  MainRepository {
    val filmDataBase = listOf(
        Film(
            "WandaVision",
            R.drawable.poster_6,
            "Blends the style of classic sitcoms with the MCU, in which Wanda Maximoff and Vision - two super-powered beings living their ideal suburban lives - begin to suspect that everything is not as it seems.",
            4.7f

        ),
        Film(
            "American Fiction",
            R.drawable.poster_5,
            "A novelist who's fed up with the establishment profiting from \"Black\" entertainment uses a pen name to write a book that propels him to the heart of hypocrisy and the madness he claims to disdain.",
            5.5f
        ),
        Film(
            "Loki",
            R.drawable.poster_7,
            "The mercurial villain Loki resumes his role as the God of Mischief in a new series that takes place after the events of “Avengers: Endgame.”",
            3.3f
        ),
        Film(
            "Beekeeper",
            R.drawable.poster_8,
            "In The Beekeeper, one man's brutal campaign for vengeance takes on national stakes after he is revealed to be a former operative of a powerful and clandestine organization known as \"Beekeepers\".",
            8.9f
        ),
        Film(
            "Mandalorian",
            R.drawable.poster_9,
            "The travels of a lone bounty hunter in the outer reaches of the galaxy, far from the authority of the New Republic.",
            9.2f
        ),
        Film(
            "Book Of Boba Fett",
            R.drawable.poster_10,
            "Bounty hunter Boba Fett and mercenary Fennec Shand navigate the underworld when they return to Tatooine to claim Jabba the Hutt's old turf.",
            8.8f
        ),
        Film(
            "Boys in the Boat",
            R.drawable.poster_11,
            "A 1930s-set story centered on the University of Washington's rowing team, from their Depression-era beginnings to winning gold at the 1936 Berlin Olympics.",
            7f
        )
    )

}