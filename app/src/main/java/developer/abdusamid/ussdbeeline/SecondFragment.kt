package developer.abdusamid.ussdbeeline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import developer.abdusamid.ussdbeeline.`object`.Object
import developer.abdusamid.ussdbeeline.adapter.MyAdapter
import developer.abdusamid.ussdbeeline.cache.ClassData
import developer.abdusamid.ussdbeeline.cache.MyShare
import developer.abdusamid.ussdbeeline.models.ClassItem
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {
    private lateinit var rootSecond: View
    private lateinit var dataListSecond: ArrayList<ClassData>
    private lateinit var arrayListItemSecond: ArrayList<ClassItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        rootSecond = inflater.inflate(R.layout.fragment_second, container, false)
        rootSecond.tv_type.text = Object.stringTypeName
        this.context?.let { MyShare.init(it) }
        dataListSecond = ArrayList()
        arrayListItemSecond = ArrayList()
        dataListSecond.addAll(MyShare.dataList!!)

        for (i in 0 until dataListSecond.size) {
            if (dataListSecond[i].stringType == Object.stringType) {
                arrayListItemSecond.add(
                    ClassItem(
                        dataListSecond[i].stringName,
                        dataListSecond[i].stringPrice
                    )
                )
            }
        }

        val myAdapter = this.activity?.let {
            MyAdapter(it, arrayListItemSecond, object : MyAdapter.MyOnClick {
                override fun onClick(stringName: String) {
                    Object.stringName = stringName
                    findNavController().navigate(R.id.thridFragment)
                }
            })
        }
        rootSecond.recyclerViewItem.adapter = myAdapter

        return rootSecond
    }
}