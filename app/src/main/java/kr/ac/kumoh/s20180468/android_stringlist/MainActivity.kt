package kr.ac.kumoh.s20180468.android_stringlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.ac.kumoh.s20180468.android_stringlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  val songs = arrayOf(
        "시간의 지평선", "Nxde", "ANTIFRAGILE", "Hype boy", "After LIKE",
    )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            songs)

        binding.list.setOnItemClickListener { _, _, i, _ ->
            val uri = Uri.parse("http://youtube.com/results?search_query=" + songs[i])
            val youtube = Intent(Intent.ACTION_VIEW, uri)
            startActivity(youtube)
        }
    }
}