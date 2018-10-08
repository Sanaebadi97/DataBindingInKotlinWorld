package sanaebadi.info.databindinginkolinworld.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import sanaebadi.info.databindinginkolinworld.BR
import sanaebadi.info.databindinginkolinworld.R
import sanaebadi.info.databindinginkolinworld.databinding.ItemRowBinding
import sanaebadi.info.databindinginkolinworld.model.DataModel

class DataAdapter(private var dataList: ArrayList<DataModel>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = DataBindingUtil.inflate<ItemRowBinding>(
                LayoutInflater.from(parent.context), R.layout.item_row,
                parent, false)


        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }


    override fun getItemCount() = dataList.size


    class ViewHolder(private val binding: ItemRowBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DataModel) {
            binding.setVariable(BR.data, data)
            // binding.data = data
            binding.executePendingBindings()
        }

    }
}