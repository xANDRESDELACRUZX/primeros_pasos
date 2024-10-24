interface AudioPlayer{
    audioVolume:number
    songDuration:number
    song:string
    details:Details
}

interface Details{
    author: string,
    year:number,
}

const audioPlayer:AudioPlayer = {
    audioVolume: 90,
    songDuration: 36,
    song: "rnldt",
    details: {
        author:"Bad bunny",
        year:2018
    }
}


const{song, songDuration, details} = audioPlayer;
const {author} = details;

console.log(song,songDuration,author);

export{}

