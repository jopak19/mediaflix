classDiagram
class Media {
Integer id
string title
string imageURL
string imdbID
string tmdbID

    }

    class Movie {
        string gender
    }

    class Serie {
        string gender
    }

    class Episode {
        int season
        int number
        Integer serie_id
    }

    Media <|-- Movie
    Media <|-- Episode
    Serie "1" o-- "0..*" Episode : contains