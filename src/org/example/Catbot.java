package org.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;
import org.riversun.xternal.simpleslackapi.SlackChannel;

public class Catbot {

	public static void main(String[] args) throws IOException {

		String botToken = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");

		SlackletService slackService = new SlackletService(botToken);



		//-----------------------------------------------------------猫URLを格納
		List<String> lists = new ArrayList<String>();
		lists.add("https://matome.naver.jp/odai/2139450632745180701");
		lists.add("https://ailovei.com/?p=16776");
		lists.add("https://matome.naver.jp/odai/2138406367427013201");
		//-----------------------------------------------------------

		//-----------------------------------------------------------機能一覧を表示
		List<String> helpLists = new ArrayList<String>();
		helpLists.add("【機能一覧】");
		helpLists.add("【疲れた】 :癒し画像を教えるニャ！");
		helpLists.add("【時間     :現在時刻を表示するニャ！");
		helpLists.add("【一覧】   :保存されているURLを確認できるニャ！");
		helpLists.add("【URL追加】:URLを追加できるニャ！（現在は使えない）");
		helpLists.add("【URL削除】:URLを削除できるニャ！（現在は使えない）");
		helpLists.add("それ以外の文字はランダムで返すニャ！");
		//-----------------------------------------------------------

		//-----------------------------------------------------------ランダムで言葉が返ってくる
		List<String> randomBot = new ArrayList<String>();
		randomBot.add("そうだニャ！");
		randomBot.add("わかったニャ！");
		randomBot.add("もう一回言ってほしいニャ！");
		randomBot.add("五月雨を 集めて早し 最上川    猫Bot");
		randomBot.add("外に出かけたいニャ！");
		randomBot.add("暇だニャ。もっとお話ししたいニャ！");
		randomBot.add("にゃにゃにゃにゃ～");
		randomBot.add("ニャんだと!?");
		randomBot.add("それは言わないで欲しいニャ。");
		randomBot.add("知らない言葉だニャ！");
		randomBot.add("それは本当ニャのか!?");
		randomBot.add("腹減ったニャ！");
		randomBot.add("いやだニャ！");
		randomBot.add("久しぶりだニャ！");
		randomBot.add("もっとかまって欲しいニャ！");
		randomBot.add("↑凄いこと言ってるニャ！");
		randomBot.add("褒めて欲しいニャ！");
		randomBot.add("今何時だニャ？");
		randomBot.add("知ってるニャ！");
		randomBot.add("こんちにはだニャ！");
		randomBot.add("ちゃんと仕事しろニャ！");
		randomBot.add("天才ニャのか！？");
		randomBot.add("この話はこれで終わりニャ！");
		randomBot.add("面白い話を聞きたいニャ！");
		//-----------------------------------------------------------


		 // slackletを追加する
        slackService.addSlacklet(new Slacklet() {
            int mode = 0;  //0なら通常処理、2.3ならURL追加削除モード


            public void teee( SlackletRequest req ) {

    			System.out.println("Sender: " + req.getSender());
    			System.out.println("コメント: " + req.getContent());
    			System.out.println("UserMail: " + req.getSender().getUserMail());
    			System.out.println("isBot: " + req.getSender().isBot());

            }

            @Override
            public void onMessagePosted(SlackletRequest req, SlackletResponse resp) {
                // メッセージがユーザーからポストされた

            	String mail = req.getSender().getUserMail();


			System.out.println("mode: " + mode);
			teee( req );

                // メッセージがポストされたチャンネルを取得する
                SlackChannel channel = req.getChannel();

                if ("random".equals(channel.getName()) && mail !=(null) ) {
                    // #randomチャンネルだった場合

                    // メッセージ本文を取得
                    String content = req.getContent();

                    if (mode == 2) {
                        lists.add(content);
                        resp.reply(content + "を追加したニャ！");
                        mode = 0;

                    } else if (mode == 3) {
                        lists.remove(content);
                        resp.reply(content + "を削除したニャ！");
                        mode = 0;
                    } else if(mode == 0){

                        //-----------------------------------------------------------条件次第で実行内容変える
                        /* 1 */
                        if (content.contentEquals("疲れた")) { //------------------疲れたと入力したらランダムでURL表示
                            Collections.shuffle(lists);
                            String result = lists.get(0);
                            resp.reply(result);
                            resp.reply("これでも見て元気になるニャ！");

                        } /* 2 */
                        else if (content.contentEquals("URL追加")) {//-------------URLを追加作業
                            mode = 2;
                            resp.reply("追加したいURLを追加するニャ！");

                            /* 3 */ } else if (content.contentEquals("URL削除")) {//--------------URLを削除作業
                            mode = 3;
                            resp.reply("削除したいURLを入力するニャ！");

                            /* 4 */ } else if (content.contentEquals("一覧")) {//-----------------URL一覧を表示
                            resp.reply("一覧だニャ！");
                            for (String helpList : lists) {
                                resp.reply(helpList);
                            }
                            resp.reply("-----------------------------");

                            /* 5 */ } else if (content.contentEquals("時間")) {//----------------時間を表示
                            Date date = new Date();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy'年'MM'月'dd'日'E'曜日'k'時'mm'分'ss'秒'");
                            resp.reply("現在時刻は" + dateFormat.format(date) + "だニャ！");

                            /* 6 */ } else if (content.contentEquals("ヘルプ")) {//--------------ヘルプ表示
                            for (String help : helpLists) {
                            resp.reply(help);
                            }
                            resp.reply("-----------------------------");

                        } else {//----------------------------------------ランダムで返す。
                            Collections.shuffle(randomBot);
                            String resultHelp = randomBot.get(0);
                            String userDisp = req.getUserDisp();
                            resp.reply(userDisp + "さん。" +  resultHelp);


                        }
                    }

                }

            }
        });

        // slackletserviceを開始(slackに接続)
        slackService.start();

    }

}
