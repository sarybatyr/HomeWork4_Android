package com.example.hw4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw4.databinding.FragmentSecondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.LinkedList


class FragmentSecond: Fragment(){

    private val BASE_URL: String = "https://jsonplaceholder.typicode.com"
    private var comments: List<String> = listOf()
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.view.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.VERTICAL, false)
        getData()
    }

    private fun getData(){
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)
        api.getComments().enqueue(object : Callback<List<Comments>> {
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                if(response.isSuccessful){

                    response.body()?.let {
                        comments = it.map {
                            it.name
                        }
                        binding.view.adapter = NameAdapter(comments)
                    }
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Log.i(">>> Error Message from Server", "${t.message}")
            }

        })
    }

}