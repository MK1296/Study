/* ■ [回答]と記載のある箇所へ、1〜8の各課題内容に沿ったSQL文を記述しなさい。 */

-- 1. Staffテーブルから「経理部」に所属する社員の情報をすべて抽出してください。
    SELECT * 
    FROM Staff
    WHERE section = '経理部';

-- 2. 在庫(Stocksテーブル)の在庫数(Quantity)が10以上25未満のものを抽出して下さい。
    SELECT *
    FROM Stocks
    WHERE Quantity >= 10 AND Quantity < 25;

-- 3. INTERSECT演算子を使用して、Order_Headerテーブルで合計値(Total)が5000以上10000未満のものを抽出して下さい。
    SELECT *
    FROM Order_Header
    WHERE Total >= 5000

    INTERSECT

    SELECT *
    FROM Order_Header
    WHERE Total < 10000;

-- 4. 「関東」エリアの全店舗情報（店舗所在地と店舗情報）を抽出して下さい。※テーブル結合すること
    SELECT *
    FROM Shop
    JOIN Area ON Shop.areacode = Area.areacode
    WHERE Area.areaname = '関東';

-- 5. 在庫(Stocksテーブル)内の各商品の合計数量を抽出して下さい。
    SELECT goodsCode, SUM(quantity) AS total_quantity
    FROM Stocks
    GROUP BY goodsCode;

-- 6. 商品（Gods）テーブルから単価（UnitPrice)が5000円より高い商品の情報を全て抽出して下さい。
    SELECT *
    FROM Goods
    WHERE UnitPrice > 5000;

-- 7. Shopテーブルの全ての店舗コード（Shopcode）、店舗名（Shopname）を、所在地（areaname）とあわせて抽出してください。
    SELECT Shop.shopcode, Shop.shopname, Area.areaname
    FROM Shop
    JOIN Area ON Shop.areacode = Area.areacode;

-- 8. 「新宿」店の在庫数が10以上の商品の商品コード（GoodsCode）、商品名（GoodsName）、在庫数（quantity）を抽出して下さい。
    SELECT Stocks.GoodsCode, Goods.GoodsName, Stocks.Quantity
    FROM Stocks
    JOIN Shop ON Stocks.ShopCode = Shop.ShopCode
    JOIN Goods ON Stocks.GoodsCode = Goods.GoodsCode
    WHERE Shop.ShopName = '新宿'
    AND Stocks.Quantity >= 10;