package com.geeks.hw8_3m

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geeks.hw8_3m.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val characterList = arrayListOf(
        CharacterModel(
            "Rick Sanchez",
            "Alive",
            "https://www.freepnglogos.com/uploads/rick-and-morty-png/rick-and-morty-non-toxic-rick-sanchez-18.png"
        ),
        CharacterModel(
            "Morty Smith",
            "Alive",
            "https://comicvine.gamespot.com/a/uploads/scale_medium/6/66303/4469088-tumblr_inline_n0aleph3fl1r8rr6o.jpg"
        ),
        CharacterModel(
            "Albert Einstein",
            "Dead",
            "https://static.tvmaze.com/uploads/images/medium_portrait/475/1189493.jpg"
        ),
        CharacterModel(
            "Jerry Smith",
            "Alive",
            "https://comicvine.gamespot.com/a/uploads/scale_small/6/66303/4472081-tumblr_n04lnrmooh1rfbbc6o1_1280.jpg"
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

    }

    private fun initAdapter() {
        val adapter = CharacterAdapter(characterList, this::onClick)
        binding.rvCharacter.adapter = adapter
    }

    private fun onClick(characterModel: CharacterModel) {
        findNavController().navigate(R.id.detailsFragment, bundleOf(Keys.KEY_FOR_CHARACTER to characterModel ))
    }
}