package developer.abdusamid.ussdbeeline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import developer.abdusamid.ussdbeeline.`object`.Object.stringName
import developer.abdusamid.ussdbeeline.`object`.Object.stringTypeName
import developer.abdusamid.ussdbeeline.cache.ClassData
import developer.abdusamid.ussdbeeline.cache.MyShare
import kotlinx.android.synthetic.main.fragment_third.view.*

class ThirdFragment : Fragment() {
    private lateinit var rootThird: View
    private lateinit var dataList: ArrayList<ClassData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        rootThird = inflater.inflate(R.layout.fragment_third, container, false)
        rootThird.tv_name.text = stringTypeName
        rootThird.tv_tarif_sms_mb_yangilik_ussd.text =
            stringName
        dataList = ArrayList()
        dataList.addAll(MyShare.dataList!!)
        for (i in 0 until dataList.size) {
            if (dataList[i].stringName == stringName) {
                rootThird.tv_description.text = dataList[i].stringDescription
            }
        }


        return rootThird
    }
}