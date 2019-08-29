# SlackBot（猫風）Ver.1.0.6
	- JavaのListとMySQLのデータベースから出力の勉強の為に作成しました。
	- 現状はMainクラス内だけですべて実行している為、時間をかけて細分化していきます。
	- [こちらのサイトを参考に作成しました。]( https://qiita.com/riversun/items/25f64f285699223a992d )

<<<<<<< HEAD
## 概要
 `
	- 疲れたと入力すると癒しサイトを紹介（List）
	- URL追加→URLを追加してニャ！(URLを追加できます。)
	- URL削除→削除するURLを入力してニャ！(URLを削除できます。)
	- 時間と入力→現在時刻表示
	- その他の言葉に対してはランダムで返信(データベース)(Java:137～169)
	  データベースはご自身で作成してください。(次回更新で自動生成できるようにします。)
 `	  

 `

## Eclipse上で利用する場合
	*先に参考サイトのご確認をお願いいたします。*
	**ディレクトリー＝ファイル**
 `
	1. 「ファイル」→「インポート」クリック。
	2. 「Git」→「Gitからプロジェクト」を選択し次へ。
	3. 「クローンURL」を選択し次へ。
	4.  URLに [https://github.com/mameosx/slacklet-catbot]( https://github.com/mameosx/slacklet-catbot )を入力し次へ。
	5. 「master」にチェックが入っていることを確認し次へ。
	6.  ディレクトリーを変更しない場合はそのまま次へ。
	7.  プロジェクトがEclipse上に表示されたのち、src/main/java直下に**credentials.properties**というファイルを作り、以下のように取得したapi tokenをセットします。
		slack.bot_api_token=xoxb-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	8.  各jarファイルをダウンロードしてくる。
		- commons-logging-1.2.jar
		- gson-2.8.5.jar
		- httpclient-4.5.9.jar
		- httpcore-4.4.11.jar
		- httpmime-4.5.9.jar
		- slacklet-1.0.4.jar
		- slf4j-api-.1.7.26.jar
		- threerenbp-1.4.0.jar
		- tyrus-standalone-client-1.15.jar
		わかりやすいように一つのフォルダにまとめておく事を推奨します。
	9.  プロジェクトを右クリックし「ビルド・パス」を選択し「ビルド・パスの構成」をクリック。
	10. 右側にある「外部jarの追加」をクリックし、上記jarファイルをすべて選択し「適用して閉じる」をクリック。
	11. Catbot.jar84行目に指定のチャンネル名を記載し実行。
	 `
	 *データベースを使わない場合、(Java:56～80)(Java:167～170)のコメントアウトを解除。(Java:173～207)をコメントアウト。*
=======
It is licensed under MIT.

## Eclipseへのインポートと実行

Eclipseへのimport

``` 
1. Select File>Import>Git - Projects from Git
2. Clone URI
3. set clone URI to https://github.com/riversun/slacklet-examples.git
4. 適宜[NEXT]を押していく
5. "Import as general project"をチェックして、"finish" を押す
```

## credentialsをセットする

```
1. プロジェクト上で、右クリック
2. Configure>Convert to Maven project
3. (これでmaven projectとしてEclipseに読み込まれます)
4. API Token for BOT をセット
```
>>>>>>> 313bf9ab3952afe7c5c2081e07af5ba89875af2f
 

## 今後の課題
	`
	- データベース自動生成しない為、修正予定
	- クラス分けをし、見やすくする



