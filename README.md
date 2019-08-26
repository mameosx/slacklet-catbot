# Overview

It is licensed under MIT.

## Eclipseへのインポートと実行

Eclipseへのimport

 `
1. Select File>Import>Git - Projects from Git
2. Clone URI
3. set clone URI to https://github.com/riversun/slacklet-examples.git
4. 適宜[NEXT]を押していく
5. "Import as general project"をチェックして、"finish" を押す
 `

## credentialsをセットする

 `
1. プロジェクト上で、右クリック
2. Configure>Convert to Maven project
3. (これでmaven projectとしてEclipseに読み込まれます)
4. API Token for BOT をセット
 `
 
src/main/java直下に**credentials.properties**というファイルを作り、以下のように取得したapi tokenをセットします
slack.bot_api_token=xoxb-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx


## 機能一覧
 
 - 時間と入力すると現在時刻を表示します。
 - 疲れたと入力すると癒してくれるサイトを紹介します。
 - ヘルプと入力するとその他出来る機能を紹介します。


### 概要
猫風Botが発言を拾いランダムで返信してくれます。
