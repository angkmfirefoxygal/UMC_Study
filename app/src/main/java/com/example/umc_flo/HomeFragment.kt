package com.example.umc_flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_flo.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){

    lateinit var binding: FragmentHomeBinding
    private var albumDatas = ArrayList<Album>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

//        binding.homeAlbumImgIv1.setOnClickListener {
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm , AlbumFragment())
//                .commitAllowingStateLoss()
//        }

        albumDatas.apply {
            add(Album("Butter","방탄소년단(BTS)",R.drawable.img_album_exp))
            add(Album("Lilac","아이유(IU)",R.drawable.img_album_exp2))
            add(Album("카리나1","에스파(aespa)",R.drawable.img_album_exp3))
            add(Album("카리나2","에스파(aespa)",R.drawable.img_album_exp4))
            add(Album("카리나3","에스파(aespa)",R.drawable.img_album_exp5))
            add(Album("카리나4","에스파(aespa)",R.drawable.img_album_exp6))


        }

        val albumRVAdapter = AlbumRVAdapter(albumDatas)
        binding.homeTodayMusicAlbumRv.adapter = albumRVAdapter
        binding.homeTodayMusicAlbumRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        albumRVAdapter.setMyItemClickListener(object : AlbumRVAdapter.MyItemClickListener{

            override fun onItemClick(album: Album) {
//                (context as MainActivity).supportFragmentManager.beginTransaction()
//                    .replace(R.id.main_frm , AlbumFragment()).apply {
//                        arguments = Bundle().apply {
//                            val gson = Gson()
//                            val albumJson = gson.toJson(album)
//                            putString("album", albumJson)
//                        }
//                    }
//                    .commitAllowingStateLoss()

                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm , AlbumFragment())
                    .commitAllowingStateLoss()


            }

            override fun onRemoveAlbum(position: Int) {
                albumRVAdapter.removeItem(position)
            }
        })

        // 레이아웃 매니저 설정

        val bannerAdapter = BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))

        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return binding.root
    }

}