package com.hfad.datianagrafici.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hfad.datianagrafici.R
import com.hfad.datianagrafici.data.User
import com.hfad.datianagrafici.viewmodel.UserViewModel
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        view.findViewById<Button>(R.id.add_btn).setOnClickListener {
            insertDataToDatabase()
        }
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = view?.findViewById<EditText>(R.id.name)?.text.toString()
        val lastName = view?.findViewById<EditText>(R.id.surname)?.text.toString()
        val age = view?.findViewById<EditText>(R.id.age)?.text.toString().toInt()
        val cityBirth = view?.findViewById<EditText>(R.id.city_birth)?.text.toString()
        val provinceBirth = view?.findViewById<EditText>(R.id.province_birth)?.text.toString()
        val sex = view?.findViewById<EditText>(R.id.sex)?.text.toString()

        if (inputCheck(firstName,lastName,age,cityBirth,provinceBirth,sex)){
            //crea un nuovo utente
            val user = User(0,firstName,lastName,Integer.parseInt(age.toString()),
                cityBirth,provinceBirth,sex)
            userViewModel.addUser(user)
            //dopo aver aggiunto l'utente ritorniamo alla list user
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(),"Incomplete data", Toast.LENGTH_LONG).show()
        }


    }
    private fun inputCheck(firstName: String,lastName:String,age:Int,cityBirth: String,
                           provinceBirth: String,sex:String): Boolean {
        return!(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) &&
                TextUtils.isEmpty(age.toString()) && TextUtils.isEmpty(cityBirth) &&
                TextUtils.isEmpty(provinceBirth) && TextUtils.isEmpty(sex))
    }

}