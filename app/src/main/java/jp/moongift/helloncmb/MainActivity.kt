package jp.moongift.helloncmb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nifcloud.mbaas.core.NCMB
import com.nifcloud.mbaas.core.NCMBObject

const val applicationKey:String = "APPLICATION_KEY"
const val clientKey:String = "CLIENT_KEY"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初期化
        NCMB.initialize(applicationContext, applicationKey, clientKey)
        // クラスのNCMBObjectを作成
        var obj = NCMBObject("TestClass")
        // オブジェクトに値を設定
        obj.put("message", "Hello, NCMB!")
        // データストアへの保存を実施
        obj.saveInBackground { e ->
            if (e != null) {
                // 保存に失敗した場合の処理
                Log.d("[Error]", e.toString())
            } else {
                // 保存に成功した場合の処理
                Log.d("[DEBUG]","保存成功")
                Log.d("[DEBUG]",obj.toString())
            }
        }
    }
}
