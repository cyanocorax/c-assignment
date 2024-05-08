## c-assignment
・言語: Java17<br />
・フレームワーク: Spring Boot<br />
・データベース: MySQL<br />

## 実行方法
```
git clone https://github.com/cyanocorax/c-assignment.git
cd c-assignment
docker-compose up
```

## エンドポイント
```
GET /students
```

## 初期データ
以下のデータが初期値としてDBに保存されています。
| 教師ID | ⽣徒ID | ⽣徒名 | ログインID | クラスID | クラス名 |
| --- | --- | --- | --- | --- | --- |
| 1 | 1 | 佐藤 | foo123 | 1 | クラスA |
| 2 | 2 | 鈴⽊ | bar456 | 2 | クラスB |
| 1 | 3 | ⽥中 | baz789 | 3 | クラスC |
| 1 | 4 | 加藤 | hoge0000 | 1 | クラスA |
| 2 | 5 | 太⽥ | fuga1234 | 2 | クラスB |
| 1 | 6 | 佐々⽊ | piyo5678 | 3 | クラスC |
| 1 | 7 | ⼩⽥原 | fizz9999 | 1 | クラスA |
| 2 | 8 | Smith | buzz777 | 2 | クラスB |
| 1 | 9 | Johnson | fizzbuzz#123 | 3 | クラスC |
| 1 | 10 | Williams | xxx:42 | 1 | クラスA |

### カラム名
カラム名はDB内では次のような対応になります。
| データ表のカラム名 | DBでのカラム名 |
| --- | --- |
| 教師ID | teacher_id |
| 生徒ID | id |
| 生徒名 | name |
| ログインID | login_id |
| クラスID | class_id |
| クラス名 | class_name |

## リクエスト
| パラメタ名 | 型 | require/optional | default | 概要 |
| --- | --- | --- | --- | --- |
| facilitator_id | int | require | 教師ID |
| page | int | optional | 1 | ページネーションのページ数。<br />デフォルト: 1 |
| limit | int | optional | 5 | ページネーションの1ページあたりの表⽰数。<br />デフォルト: 5 |
| sort | string | optional | id | ソートのキーとしてレスポンスにある以下のフィールドを指定できる<br />・id: ⽣徒ID<br />・name: ⽣徒名<br />・loginId: ログインID |
| order | string | optional | asc | ソートの昇順=asc, 降順=descを指定する |
| {key}_like | string | optional | | 指定したレスポンスのフィールドによる部分⼀致検索をします。<br />{key}にはレスポンスにある以下のフィールドを指定できる。<br />・name: ⽣徒名<br />・loginId: ログインID |

### リクエスト例
```
curl 'https://127.0.0.1:48080/students?facilitator_id=1'
```

## レスポンス
| フィールド | 型 | 概要 |
| --- | --- | --- |
| $.students | array | |
| $.students[*].id | int | ⽣徒ID |
| $.students[*].name | string | ⽣徒名 |
| $.students[*].loginId | string | ログインID |
| $.students[*].classroom | array | |
| $.students[*].classroom[*].id | int | クラスID |
| $.students[*].classroom[*].name | string | クラス名 |
| $.totalCount | int | リクエストの条件に該当する件数 |

### レスポンス例
```
{
 "students": [
  {
   "id": 1,
   "name": "佐藤",
   "loginId": "foo123",
   "classroom": {
    "id": 1,
    "name": "クラスA"
   }
  }
 ],
 "totalCount": 1
}
```

## エラー
| 状況 | レスポンスコード |
| --- | --- |
| リクエストに該当する⽣徒が存在しない | 404 Not Found |
| リクエストに問題がある | 400 Bad Request |
