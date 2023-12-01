package com.example.compose.day567.model

import com.example.compose.R

data class MovieData(
    val image: String = "",
    val name: String,
    val summary: String,
    val year: String,
    val director: String,
    val actors: List<String> = emptyList(),
    val budget: String,
    val imdb: String
)

fun getMovieList() = listOf(
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/old-spice-man-blue.png",
        name = "Gumraah ",
        imdb = "7.0",
        year = "2023",
        director = "Aryan Kapoor",
        budget = "50",
        actors = arrayListOf("Aditya Roy Kapur", "Mrunal Thakur", "Karan Kundra"),
        summary = "A gripping thriller about identical twins, Shivani and Dhiren, who find themselves entangled in a murder mystery. As the investigation deepens, their lives intertwine in unexpected ways, leading to a shocking revelation."
    ),
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
        name = "Bro ",
        imdb = "6.7",
        year = "2023",
        director = "Samuthirakani",
        budget = "70",
        actors = arrayListOf("Pawan Kalyan", "Sai Dharam Tej", "Urvashi Rautela"),
        summary = "An arrogant man, Arjun, is given a second chance to mend his ways after death. Through a series of life-altering experiences, he embarks on a journey of self-discovery and redemption."

    ),
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/spunky-sam-green.png",
        name = "Vadh  ",
        imdb = "8.0",
        year = "2023",
        director = "Jaspal Singh Sandhu",
        budget = "20",
        actors = arrayListOf("Sanjay Mishra", "Neena Gupta", "Saurabh Sachdeva"),
        summary = "A retired school teacher, Mohan, finds his peaceful life shattered when a mysterious stranger enters his home. As the stranger's true intentions are revealed, Mohan must confront his inner demons to protect his family."
    ),
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/duskpin-sapling.png",
        name = "Uunchai  ",
        imdb = "7.7",
        year = "2022",
        director = "Sooraj Barjatya",
        budget = "35",
        actors = arrayListOf("Amitabh Bachchan", "Anupam Kher", "Boman Irani"),
        summary = "Three friends embark on a trek to Mount Everest to fulfill a lifelong dream. Their journey is filled with moments of friendship, self-discovery, and the realization that life's true summit lies within."
    ),
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/duskpin-seedling.png",
        name = "Blurr  ",
        imdb = "6.5",
        year = "2022",
        director = "Ajay Bahl",
        budget = "40",
        actors = arrayListOf("Taapsee Pannu", "Gulshan Devaiah", "Abhilash Thapliyal"),
        summary = "Gayatri, a blind woman, returns home after six months to find her twin sister, Gautami, dead. As she investigates the circumstances surrounding her sister's death, she uncovers dark secrets and must confront her own fears."
    ),
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/marcimus-orange.png",
        name = "Raksha Bandhan ",
        imdb = "6.2",
        year = "2022",
        director = "Aryan Kapoor",
        budget = "80",
        actors = arrayListOf("Akshay Kumar", "Bhumi Pednekar", "Sahejveer Wadhwa"),
        summary = "A brother's unwavering love for his four sisters takes him on a mission to get them all married. Amidst the chaos of wedding preparations, he faces challenges and discovers the true meaning of family."
    ),
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/marcimus.png",
        name = "Laal Singh Chaddha ",
        imdb = "7.8",
        year = "2022",
        director = "Advait Chandan",
        budget = "180",
        actors = arrayListOf("Aamir Khan", "Kareena Kapoor Khan", "Naga Chaitanya"),
        summary = "An extraordinary tale inspired by the American classic Forrest Gump, Laal Singh Chaddha follows the life of Laal Singh, a simple and innocent man who witnesses the most pivotal moments of Indian history."
    ),
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/mr-pants.png",
        name = "Vikrant Rona ",
        imdb = "5.8",
        year = "2022",
        director = " Anup Bhandari",
        budget = "95",
        actors = arrayListOf(" Sudeep", "Jacqueline Fernandez", "Nirup Bhandari"),
        summary = "A police officer in a remote village faces a series of mysterious child disappearances. As he delves deeper into the investigation, he uncovers a sinister truth that threatens to shatter the peace of the community."
    ),
    MovieData(
        image = "https://www.kasandbox.org/programming-images/avatars/mr-pants.png",
        name = "Dhaakad",
        imdb = "5.5",
        year = "2022",
        director = "Razneesh Ghai",
        budget = "60",
        actors = arrayListOf("Kangana Ranaut", "Arjun Rampal", "Divya Seth"),
        summary = "Agent Agni, an elite black ops agent, embarks on a dangerous mission to uncover a global arms conspiracy. Her journey is filled with action, suspense, and the revelation of a shocking betrayal."
    )
)
