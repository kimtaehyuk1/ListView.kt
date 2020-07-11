package com.example.listviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter() // context는 안드로이드 엑티비티 정보를 담고있다.  // ArrayList안에 아까 만들어준 class인 User형태로 담아주기 배열리스트에
{                                       // 빨간불 들어온곳에 커서대고 알트엔터 눌러서 implement 왜냐면 BaseAdapter를 상속받아서, Ctrl a 누르면 다 같이 눌러짐
                                       //뭔가 UserAdapter라는 자체가 이름이지만 기능은 사용할유저옵션들과 리스트뷰 연결? 그안에 유저목록이 들어감 리스트형태로
                                       // 왜 ()안에 저 내용 들어갔는지 이해하기 살짝 간단한 ArrayAdapter기능 유사 이건 이내용이 들어갈가거는 얘기지 메인에서 UserList 구현현
                                       // 다듬기 position, converterView,parent 변수들 바꾸고 투두 지우기
    override fun getView(position: Int, converterView: View?, parent: ViewGroup?): View {
        // 여기 메소드에서는 리스트뷰에서 뷰를 얻었을때 어떻게 뿌려줄꺼냐
        // layoutinflater는 뷰를 붙여주는거
           val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user,null)
           //이미지뷰가 어떤 리스트가 붙건 만들어주는 일
            //<>안에는 형태 , id로부터 뷰를 찾아라
           val profile = view.findViewById<ImageView>(R.id.iv_profile)
           val name = view.findViewById<TextView>(R.id.tv_name)
           val age = view.findViewById<TextView>(R.id.tv_age)
           val greet = view.findViewById<TextView>(R.id.tv_greet)

           val user = UserList[position]   // UserList에 위치에 할당하는 변수 만들어준거임

           profile.setImageResource(user.profile)
           name.text = user.name
           age.text = user.age
           greet.text = user.greet

           return view
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return UserList.size
    }
}