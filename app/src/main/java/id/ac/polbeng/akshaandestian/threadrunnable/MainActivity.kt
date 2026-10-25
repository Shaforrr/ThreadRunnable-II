package id.ac.polbeng.akshaandestian.threadrunnable

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ac.polbeng.akshaandestian.threadrunnable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Worker().execute()
        }
    }

    @Suppress("DEPRECATION")
    inner class Worker : AsyncTask<Void, String, Boolean>() {

        override fun doInBackground(vararg params: Void?): Boolean {

            for (i in 1..20) {

                publishProgress("i: $i")

                Thread.sleep(2000)
            }

            return true
        }

        override fun onProgressUpdate(vararg values: String?) {

            binding.textView.text = values[0]

            println(values[0])
        }

        override fun onPostExecute(result: Boolean) {

            println(result)
        }
    }
}
