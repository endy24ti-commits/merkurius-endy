package com.example.merkurius_endy.Message

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.merkurius_endy.Message.Tutorial.TutorialMessageActivity
import com.example.merkurius_endy.R
import com.example.merkurius_endy.databinding.FragmentHomeBinding
import com.example.merkurius_endy.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?img=1","25"),
        MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?img=2", "24"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?img=3", "23"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?img=4", "22"),
        MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?img=5", "21"),
        MessageModel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?img=6", "20"),
        MessageModel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?img=7", "19"),
        MessageModel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?img=8", "18"),
        MessageModel("Irfan", "Oke noted", "https://i.pravatar.cc/150?img=9", "17"),
        MessageModel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?img=10", "16")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
            setHasOptionsMenu(true)
        }
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItem.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}