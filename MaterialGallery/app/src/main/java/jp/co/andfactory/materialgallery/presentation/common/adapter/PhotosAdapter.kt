package jp.co.andfactory.materialgallery.presentation.common.adapter

import android.content.Context
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import jp.co.andfactory.materialgallery.databinding.GridItemMaterialPhotoBinding
import jp.co.andfactory.materialgallery.domain.model.MaterialPhoto


class PhotosAdapter internal constructor(context: Context, private val items: MutableList<MaterialPhoto>, private val listener: OnItemClickListener) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(GridItemMaterialPhotoBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val a = items[position]
        holder.binding.photo = a
        holder.binding.root.setOnClickListener {
            ViewCompat.setTransitionName(holder.binding.photoImage, a.id.toString())
            listener.onItemClick(holder.binding.photoImage, a)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(position: Int): Long {
        return items[position].hashCode().toLong()
    }

    fun addItems(list: List<MaterialPhoto>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(view: ImageView, item: MaterialPhoto)
    }

    class ViewHolder(var binding: GridItemMaterialPhotoBinding) : RecyclerView.ViewHolder(binding.root)
}
