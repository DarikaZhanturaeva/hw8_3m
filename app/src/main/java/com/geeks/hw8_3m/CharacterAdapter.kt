package com.geeks.hw8_3m

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geeks.hw8_3m.databinding.ItemCharacterBinding

class CharacterAdapter(
    private var characterList: List<CharacterModel>,
    private val onClick: (model: CharacterModel) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])

        /* holder.itemView.setOnClickListener(){
             onClick(position)
         }*/
    }


    inner class ViewHolder(private var binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterModel) {
            binding.apply {
                tvLife.text = character.life
                tvName.text = character.name
                imgCharacter.loadImage(character.imageCharacter)

                itemView.setOnClickListener() {
                    onClick(character)
                }
            }

        }
    }
}
