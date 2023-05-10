package com.example.demoproject.binding

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoproject.model.SongModel

class DataBindingDemoViewModel: ViewModel() {
//    lateinit var context: Context
    private val _songs = MutableLiveData<SongModel>()
    val songs: LiveData<SongModel> = _songs
    val helper = Helper()
     val songData = listOf(
         SongModel(
             "Less then Hero", "3:32", "Remember I was your hero, yeah\n" +
                     "I'd wear your heart like a symbol\n" +
                     "I couldn't save you from my darkest truth of all\n" +
                     "I know\n" +
                     "I'll always be less than zero\n" +
                     "Oh yeah\n" +
                     "You tried your best with me, I know\n" +
                     "I couldn't face you with my darkest truth of all\n" +
                     "Oh\n" +
                     "'Cause I can't get it out of my head\n" +
                     "And no, I can't shake this feeling that crawls in my bed\n" +
                     "I try to hide it, but I know you know me\n" +
                     "I try to fight it, but I'd rather be free\n" +
                     "Oh, oh\n" +
                     "Oh yeah\n" +
                     "Can we meet in the middle?\n" +
                     "Oh yeah\n" +
                     "'Cause you were just like me before\n" +
                     "Now you'd rather leave me\n" +
                     "Than to watch me die in your arms\n" +
                     "Oh, whoa\n" +
                     "But I can't get it out of my head\n" +
                     "No, I can't shake this feeling that crawls in my bed\n" +
                     "I try to hide it, but I know you know me\n" +
                     "I try to fight it, but I'd rather be free\n" +
                     "Oh, whoa (hey)\n" +
                     "ooh\n" +
                     "(I try to) ooh\n" +
                     "(I try to)\n" +
                     "I can't get it out of my head\n" +
                     "No, I can't shake this feeling that crawls in my bed\n" +
                     "I try to hide it, but I know you know me (know me)\n" +
                     "I try to fight it, but I'd rather be free (be free)\n" +
                     "Yeah\n" +
                     "I'll always be less than zero\n" +
                     "You tried your best with me, I know"
         ),
         SongModel(
             "Take my breath", "5:32", "I saw the fire in your eyes\n" +
                     "I saw the fire when I look into your eyes\n" +
                     "You tell me things you wanna try, uh\n" +
                     "I know temptation is the devil in disguise\n" +
                     "You risk it all to feel alive, oh yeah\n" +
                     "You're offering yourself to me like sacrifice\n" +
                     "You said you do this all the time\n" +
                     "Tell me you love me if I bring you to the light\n" +
                     "It's like a dream what she feels with me\n" +
                     "She loves to be on the edge\n" +
                     "Her fantasy is okay with me\n" +
                     "Then suddenly, baby says\n" +
                     "Take my breath away\n" +
                     "And make it last forever, babe\n" +
                     "Do it now or never, babe, uh\n" +
                     "Take my breath away\n" +
                     "Nobody does it better, babe\n" +
                     "Bring me close to\n" +
                     "Want me to hold onto you tight\n" +
                     "You pull me closer, I feel the heat between your thighs (uh, say)\n" +
                     "You're way too young to end your life (huh)\n" +
                     "Girl, I don't wanna be the one who pays the price\n" +
                     "Ooh, it's like a dream what she feels with me\n" +
                     "She loves to be on the edge\n" +
                     "Her fantasy is okay with me\n" +
                     "Then suddenly, baby says\n" +
                     "Take my breath away\n" +
                     "And make it last forever, babe\n" +
                     "Do it now or never, babe, uh\n" +
                     "Take my breath away\n" +
                     "Nobody does it better, babe\n" +
                     "Bring me close to heaven, babe, uh\n" +
                     "Take my breath\n" +
                     "Oh, oh-ooh\n" +
                     "And they'll see me (yeah)\n" +
                     "Oh-ooh, ooh (yeah)\n" +
                     "Oh-oh, oh-oh\n" +
                     "Oh-oh, oh-oh\n" +
                     "Oh-oh, oh-oh\n" +
                     "Oh-oh\n" +
                     "Take my breath away (take my breath, my breath away)\n" +
                     "And make it last forever, babe\n" +
                     "Do it now or never, babe, uh\n" +
                     "Take my breath away (take my breath, my breath away)\n" +
                     "Nobody does it better, babe\n" +
                     "Bring me close to heaven, babe (oh)\n" +
                     "Take my breath (take my breath, my breath away)\n" +
                     "(Nobody)\n" +
                     "Take my breath (take my breath, my breath away)\n" +
                     "Nobody does it better, babe (better)\n" +
                     "Bring me close to heaven, babe, uh\n" +
                     "Take my breath"
         )
     )
    init {
        _songs.value = songData[0]
    }

    private var toggleSong = false
    fun toggle() {
        toggleSong = !toggleSong
        _songs.value = if (toggleSong) { songData[1] } else { songData[0] }
        Log.e("Song","${songs.value}")
    }
}