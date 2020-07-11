package com.example.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.bot, "김배흑1", "23", "아령하세요1"),
        User(R.drawable.bot, "김배흑2", "24", "아령하세요2"),
        User(R.drawable.bot, "김배흑3", "25", "아령하세요3"),
        User(R.drawable.bot, "김배흑4", "26", "아령하세요4"),
        User(R.drawable.bot, "김배흑5", "27", "아령하세요5"),
        User(R.drawable.bot, "김배흑6", "28", "아령하세요6"),
        User(R.drawable.bot, "김배흑7", "29", "아령하세요7")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val item = arrayOf("사과","배","딸기","키위","김배흑") //이건 걍 배열
//        listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, item) //리스트뷰(초반xml에세팅해논 id값)에는 어댑터 연결되어 있어야 데이터 인풋 가능
//        //ArrayAdapter형식 외우기(자신,레이아웃,배열) 중간에있는 레이아웃 형태로 배열받은 데이터를 화면에 리스트 하겠다

        //Ctrl / 누르면 전제 주석처리

        //Step1)한리스트에 뿌려줄 데이터를 어떤것들을 선언할거냐 모델 객체를 만들어 주어야함
        //옆에 com.example.여기 우클릭후 뉴 kotlin file/class 그냥 빈화면에 클래스 지정지정
        //Step2) 레이아웃도 만들어줌 xml파일 하나 더 만들어서(design으로 이미지뷰 컨스트렉트 뷰 섞였을때 만질줄알기)
        //Step3) Adapter코드 만들어 주기(따로 코틀린 파일 만들어서)

        val Adapter = UserAdapter(this,UserList)
        listView.adapter = Adapter

        //여기서 부턴 토스트형식으로 그 리스트 한개 눌렀을때 정보뜨는거
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this,selectItem.name,Toast.LENGTH_SHORT).show()

        }




    }
}