package developer.abdusamid.ussdbeeline

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdusamid.ussdbeeline.`object`.Object
import developer.abdusamid.ussdbeeline.cache.ClassData
import developer.abdusamid.ussdbeeline.cache.MyShare
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    private lateinit var rootHome: View
    private lateinit var dataListHome: ArrayList<ClassData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootHome = inflater.inflate(R.layout.fragment_home, container, false)
        this.activity?.let { MyShare.init(it) }
        dataListHome = ArrayList()
        dataListHome.addAll(MyShare.dataList!!)
        if (dataListHome.isEmpty()) {
            firstUse()
        }

        rootHome.btn_card_internet.setOnClickListener {
            fragmentNavigator("Internet paketlar", "internet")
        }
        rootHome.btn_card_tarif.setOnClickListener {
            fragmentNavigator("Ta'riflar", "tarif")
        }
        rootHome.btn_card_daqiqa.setOnClickListener {
            fragmentNavigator("Daqiqalar", "daqiqa")
        }
        rootHome.btn_card_yangilik.setOnClickListener {
            fragmentNavigator("Yangiliklar", "yangilik")
        }
        rootHome.btn_card_sms.setOnClickListener {
            fragmentNavigator("SMS paketlar", "sms")
        }
        rootHome.btn_card_ussd.setOnClickListener {
            fragmentNavigator("USSD kodlar", "ussd")
        }
        rootHome.photo_ic_instagram.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://instagram.com/beeline_uzbekistan?utm_medium=copy_link")
            )
            startActivity(intent)
        }
        rootHome.photo_ic_telegram.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=beelineuzbekistan"))
            startActivity(intent)
        }

        return rootHome
    }

    private fun fragmentNavigator(stringTypeName: String, stringType: String) {
        Object.stringType = stringType
        Object.stringTypeName = stringTypeName
        findNavController().navigate(R.id.secondFragment)
    }

    private fun firstUse() {
        dataListHome.add(
            ClassData(
                "internet",
                "Internet-Paket 75 GB",
                "110 000 so'm",
                "Ulanish narxi 110 000 so'm  " +
                        "GB barcha yo'nalishlarga 75 GB"
            )
        )

        dataListHome.add(
            ClassData(
                "internet",
                "Internet-Paket 50 GB",
                "90 000 so'm",
                "Ulanish narxi 90 000 so'm " +
                        "GB barcha yo'nalishlarga 50 GB"
            )
        )

        dataListHome.add(
            ClassData(
                "internet",
                "Internet-Paket 30 GB",
                "75 000 so'm",
                "Ulanish narxi 75 000 so'm " +
                        "GB barcha yo'nalishlarga 30 GB"
            )
        )

        dataListHome.add(
            ClassData(
                "tarif",
                "ZO'R 3",
                "20 000 so'm",
                "Oylik aboonent to'lovi 20 000 so'm  " +
                        "Internet barcha yo'nalishlarga 3 GB O'zbekiston bo'yicha daqiqalar 1 500 min O'zbekiston bo'yicha SMS 1 500"
            )
        )

        dataListHome.add(
            ClassData(
                "tarif",
                "ZO'R 5",
                "27 000 so'm",
                "Oylik aboonent to'lovi 27 000 so'm  " +
                        "Internet barcha yo'nalishlarga 5 GB O'zbekiston bo'yicha daqiqalar 2 500 min O'zbekiston bo'yicha SMS 2 500"
            )
        )

        dataListHome.add(
            ClassData(
                "tarif",
                "ZO'R 7",
                "35 000 so'm",
                "Oylik aboonent to'lovi 35 000 so'm  " +
                        "Internet barcha yo'nalishlarga 7 GB O'zbekiston bo'yicha cheksiz qo'ng'iroqlar ∞ O'zbekiston bo'yicha SMS 5 000"
            )
        )

        dataListHome.add(
            ClassData(
                "daqiqa",
                "200 Daqiqa",
                "10 000 so'm",
                "Narxi 10 000 so'm Muddati 30 kun"
            )
        )
        dataListHome.add(
            ClassData(
                "daqiqa",
                "400 Daqiqa",
                "18 000 so'm",
                "Narxi 18 000 so'm Muddati 30 kun"
            )
        )
        dataListHome.add(
            ClassData(
                "daqiqa",
                "600 Daqiqa",
                "25 000 so'm",
                "Narxi 25 000 so'm Muddati 30 kun"
            )
        )

        dataListHome.add(ClassData("sms", "20 SMS", "500 so'm", "Narxi 500 so'm Yoqish *110*161#"))
        dataListHome.add(
            ClassData(
                "sms",
                "50 SMS",
                "1 000 so'm",
                "Narxi 1 000 so'm Yoqish *110*162#"
            )
        )
        dataListHome.add(
            ClassData(
                "sms",
                "250 SMS",
                "1 300 so'm",
                "Narxi 1 300 so'm Yoqish *110*151#"
            )
        )

        dataListHome.add(
            ClassData(
                "yangilik",
                "HURMATLI ABONENTLAR!",
                "25.01.2022",
                "Sizga shuni ma'lum qilamizki , mobil tarmog'imiz odatiy tizimda ishlamoqda . Buning uchun \" Beeline \" dizel generatorlari va boshqa mustaqil elektr energiyasi manbalaridan foydalanmoqda . Xizmat ko'rsatish ofislari ham ochiq va tashrif buyuruvchilarni kutmoqda . Siz noqulayliklarni his qilmasligingiz uchun barcha imkoniyatlarimizni ishga solmoqdamiz ."
            )
        )
        dataListHome.add(
            ClassData(
                "yangilik",
                "10 GB INTERNET-PAKETIDAN FOYDALANUVCHILAR ABONENTLARIMIZ DIQQATIGA!",
                "07.01.2022",
                "Hurmatli abonentlar ! Shuni ma'lum qilamizki , 2022 yil 17 yanvardan boshlab 10 Gb internet - paketining narxi 45 000 so'mni tashkil etadi ."
            )
        )
        dataListHome.add(
            ClassData(
                "yangilik",
                "ROSSIYAGA UYDAGIDEK YANGI TARIFI BILAN BIRGA!",
                "24.01.2022",
                "Do'stlar ! Rossiyada aloqa uchun qulay tarifni istaysizmi ? \" Uydagidek \" yangi tarif rejasiga ulaning , muloqot qiling va Rossiyada Internetdan uydagidek foydalaning ! Abonent to'loviga nafaqat O'zbekiston bo'ylab daqiqalar , Mb va SMSlar , balki Rossiya bo'ylab Internet va aloqa uchun qo'ng'iroqlar ham kiradi ! Va bularning barchasi oyiga atigi 55 000 so'mga !"
            )
        )

        dataListHome.add(ClassData("ussd", "Hisobning holati", "*102#", " Hisobning holati *102#"))
        dataListHome.add(
            ClassData(
                "ussd",
                "MB qoldig'i haqida ma'lumot",
                "*103#",
                " MB qoldig'i haqida ma'lumot *103#"
            )
        )
        dataListHome.add(
            ClassData(
                "ussd",
                "SMS qoldig'i haqida ma'lumot",
                "*105#",
                " SMS qoldig'i haqida ma'lumot *105#"
            )
        )

        MyShare.dataList = dataListHome
    }
}