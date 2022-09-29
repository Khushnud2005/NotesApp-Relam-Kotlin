package uz.exemple.notes_room_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.notes_room_kotlin.model.Notes
import uz.exemple.notesapp_relam_kotlin.R


class NotesAdapter(var context: Context,var items:ArrayList<Notes>):RecyclerView.Adapter<NotesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.date.setText(item.date)
        holder.note.setText(item.note)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var date: TextView
        lateinit var note: TextView

        init {
            date = itemView.findViewById(R.id.tv_date)
            note = itemView.findViewById(R.id.tv_note)

        }
    }

}