package com.taipeizooplants.model.items;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemPlants {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        /**
         * limit : 5
         * offset : 0
         * count : 20
         * sort :
         * results : [{"F_Name_Latin":"Lagerstroemia speciosa","F_pdf02_ALT":null,"F_Location":"臺灣動物區；蟲蟲探索谷；兒童動物區；熱帶雨林區；白手長臂猿島","F_pdf01_ALT":null,"rank":0.0573088,"F_Summary":"","F_Pic01_URL":null,"_full_count":"20","F_pdf02_URL":null,"F_Pic02_URL":null,"F_Keywords":"","F_Code":null,"F_Geo":"MULTIPOINT ((121.5804577 24.9979216), (121.5805328 24.9959671), (121.582185 24.9984662), (121.5836763 24.9957094), (121.5816861 24.9980966))","F_Pic03_URL":null,"F_Voice01_ALT":null,"F_AlsoKnown":"爆炸樹、大果紫薇、大葉紫薇、洋紫薇、百日紅","F_Voice02_ALT":null,"F_Name_Ch":"大花紫薇","F_Pic04_ALT":null,"F_Name_En":"Queen lagerstroemia、Queen crape myrtle","F_Brief":"原產於澳洲、熱帶亞洲。生長快速，木材堅硬，耐腐力強，色紅而光亮，價值媲美柚木。","F_Pic04_URL":null,"F_Voice01_URL":null,"F_Feature":"落葉喬木，可高達25公尺，樹幹通直，樹皮光滑，呈片狀剝落。單葉對生，革質，葉呈長橢圓形，長度10~28公分，寬度5~12公分，脫落前會變紅。花朵直徑5~8公分，花瓣有6枚，長度2.5~3.5公分，接近圓形，邊緣呈不規則波浪狀，早上初開時呈紅色，傍晚轉為紫紅色。果實直徑約3.5公分，呈球形，分裂成6瓣，初生時呈綠色，成熟時轉褐色。種子扁平具有翅，有利隨風散播。","F_Pic02_ALT":null,"F_Family":"千屈菜科Lythraceae","F_Voice03_ALT":null,"F_Voice02_URL":null,"F_Pic03_ALT":null,"F_Pic01_ALT":null,"F_CID":null,"F_pdf01_URL":null,"F_Vedio_URL":null,"F_Genus":"紫薇屬Lagerstroemia","F_Function＆Application":"1. 園藝景觀植栽用：花大、美麗，開花時，花團錦簇，甚為壯觀。秋季滿樹金黃的葉子，常栽培於庭園供觀賞或作行道樹用。","F_Voice03_URL":null,"F_Update":null,"_id":6},{"F_Name_Latin":"Deutzia pulchra","F_pdf02_ALT":"","F_Location":"臺灣動物區；熱帶雨林區","F_pdf01_ALT":"","rank":0.0573088,"F_Summary":"","F_Pic01_URL":"http://www.zoo.gov.tw/iTAP/04_Plant/Saxifragaceae/pulchra/pulchra_1.jpg","_full_count":"20","F_pdf02_URL":"","F_Pic02_URL":"","F_Keywords":"","F_Code":"","F_Geo":"MULTIPOINT ((121.5804577 24.9979216), (121.5836763 24.9957094))","F_Pic03_URL":"","F_Voice01_ALT":"","F_AlsoKnown":"白埔姜、常山、百祥花、大花溲疏、美麗溲疏","F_Voice02_ALT":"","F_Name_Ch":"大葉溲疏","F_Pic04_ALT":"","F_Name_En":"Evergreen deutzia","F_Brief":"分布於菲律賓呂宋島北部及臺灣，在臺灣主要分布於中高海拔山區，蘭嶼也有。","F_Pic04_URL":"","F_Voice01_URL":"","F_Feature":"可為灌木或小喬木。葉呈卵形至長橢圓形，質地如皮革，雙面皆有星狀鱗片貼伏，上表面呈暗綠色，下表面則呈淡綠色。花穗可長達15公分，花軸多毛，花朵眾多，花瓣長度12公厘，寬度3公厘，呈白色披針形，雄蕊與花瓣大致等長。","F_Pic02_ALT":"","F_Family":"虎耳草科Saxifragaceae","F_Voice03_ALT":"","F_Voice02_URL":"","F_Pic03_ALT":"","F_Pic01_ALT":"花開後有淡香深受人們喜愛","F_CID":"","F_pdf01_URL":"","F_Vedio_URL":"","F_Genus":"溲疏屬Deutzia","F_Function＆Application":"1.園藝用途：花潔白、有淡香味，可作庭植添景樹，花、果枝則供作花材。","F_Voice03_URL":"","F_Update":"2017/9/4","_id":8},{"F_Name_Latin":"Pongamia pinnata","F_pdf02_ALT":null,"F_Location":"臺灣動物區；蕨園；兒童動物區；熱帶雨林區；澳洲動物區；非洲動物區；門內外廣場","F_pdf01_ALT":null,"rank":0.0573088,"F_Summary":"","F_Pic01_URL":null,"_full_count":"20","F_pdf02_URL":null,"F_Pic02_URL":null,"F_Keywords":"","F_Code":null,"F_Geo":"MULTIPOINT ((121.5804577 24.9979216), (121.5808258 24.9981769), (121.582185 24.9984662), (121.5836763 24.9957094), (121.5855083 24.9944599), (121.5867072 24.9945377), (121.5811899 24.9986995))","F_Pic03_URL":null,"F_Voice01_ALT":null,"F_AlsoKnown":"九重吹、水流豆、臭腥仔、鳥樹、重吹舅、掛錢樹、野豆","F_Voice02_ALT":null,"F_Name_Ch":"水黃皮","F_Pic04_ALT":null,"F_Name_En":"Poonga-oil tree、Poongaoil、Poongaoil pongamia、Pongam oiltree、Pongamia","F_Brief":"分布於印度、馬來西亞、中國南部、琉球群島至澳洲北部。在臺灣主要分布於南部濱海。","F_Pic04_URL":null,"F_Voice01_URL":null,"F_Feature":"半落葉中型喬木。整片葉長30公分，寬20公分，分出5~7片小葉，小葉數量通常為奇數，長度6~10公分，寬度3~5公分，呈卵形或長橢圓形，質感類似薄皮革，雙面光滑無毛，邊緣呈波浪狀。花穗長在葉柄與莖的接合處，花朵呈淡紫色。果莢長度4~7公分，寬度2.5~3公分，呈扁平鐮刀狀，質感等同木材，不會開裂，內僅含1顆種子，少有2顆。","F_Pic02_ALT":null,"F_Family":"蝶形花科Papilionaceae","F_Voice03_ALT":null,"F_Voice02_URL":null,"F_Pic03_ALT":null,"F_Pic01_ALT":null,"F_CID":null,"F_pdf01_URL":null,"F_Vedio_URL":null,"F_Genus":"水黃皮屬Pongamia","F_Function＆Application":"1. 優良水土保持樹種：其生長快速，生性強健，樹冠傘形，枝葉濃密，抗風、耐乾旱，適合種為海岸護堤、防風林使用。 ","F_Voice03_URL":null,"F_Update":null,"_id":33},{"F_Name_Latin":"Hypericum subalatum","F_pdf02_ALT":"","F_Location":"臺灣動物區；熱帶雨林區","F_pdf01_ALT":"","rank":0.0573088,"F_Summary":"","F_Pic01_URL":"http://www.zoo.gov.tw/iTAP/04_Plant/Guttiferae/subalatum/subalatum_1.jpg","_full_count":"20","F_pdf02_URL":"","F_Pic02_URL":"","F_Keywords":"","F_Code":"","F_Geo":"MULTIPOINT ((121.5804577 24.9979216), (121.5836763 24.9957094))","F_Pic03_URL":"","F_Voice01_ALT":"","F_AlsoKnown":"絲海棠、土連翹、小汗淋草、小過路黃、小對月草、貫葉連翹、小對葉草、聖約翰草","F_Voice02_ALT":"","F_Name_Ch":"方莖金絲桃","F_Pic04_ALT":"","F_Name_En":"Four-angled Stem","F_Brief":"臺灣特有種，分布於海拔400~900公尺的石灰岩裂縫，如新北市新店、宜蘭龜山島及花蓮縣。","F_Pic04_URL":"","F_Voice01_URL":"","F_Feature":"灌木，莖呈方形。葉片沒有葉柄，長2~7公分，寬0.5~1.5公分，呈長橢圓形，上表面具有明顯的灰白色油腺點。枝條末端通常開1~3朵花，葉柄與莖的接合處偶爾會開多達12朵花，花朵直徑2.5公分，花瓣長1~1.2公分，寬6~7公厘，呈黃色；雄蕊具有琥珀色腺體，每朵花有5束雄蕊，每束有15枚雄蕊，共有75枚。果實長7~9公厘，寬3~4公厘，形狀類似狹長的雞蛋或圓柱體。","F_Pic02_ALT":"","F_Family":"金絲桃科Guttiferae","F_Voice03_ALT":"","F_Voice02_URL":"","F_Pic03_ALT":"","F_Pic01_ALT":"盛開的金絲桃花朵相當搶眼","F_CID":"","F_pdf01_URL":"","F_Vedio_URL":"","F_Genus":"金絲桃屬Hypericum","F_Function＆Application":"1. 觀賞用：花朵於四~五月盛開。","F_Voice03_URL":"","F_Update":"2017/9/4","_id":23},{"F_Name_Latin":"Lagerstroemia subcostata","F_pdf02_ALT":null,"F_Location":"臺灣動物區；蟲蟲探索谷；熱帶雨林區；鳥園；兩棲爬蟲動物館","F_pdf01_ALT":null,"rank":0.0573088,"F_Summary":"","F_Pic01_URL":null,"_full_count":"20","F_pdf02_URL":null,"F_Pic02_URL":null,"F_Keywords":"","F_Code":null,"F_Geo":"MULTIPOINT ((121.5804577 24.9979216), (121.5805328 24.9959671), (121.5836763 24.9957094), (121.5894029 24.9951126), (121.5899205 24.9945669))","F_Pic03_URL":null,"F_Voice01_ALT":null,"F_AlsoKnown":"苞飯花、拘那花、小果紫薇、南紫薇、猴不爬、怕癢樹、南紫薇、九荊、馬鈴花、蚊仔花","F_Voice02_ALT":null,"F_Name_Ch":"九芎","F_Pic04_ALT":null,"F_Name_En":"Subcostate Crape Myrtle","F_Brief":"分布於中低海拔森林及長江以南的地區，為台灣的原生樹種。主要生長在潮濕的崩塌地，有吸水保持土壤之特性，所以是良好的水土保持樹種。","F_Pic04_URL":null,"F_Voice01_URL":null,"F_Feature":"紅褐色的樹皮剝落後呈灰白色，樹幹光滑堅硬。葉有極短的柄，長橢圓形或卵形，全綠，葉片兩端尖，秋冬轉紅。夏季6～8月開花，花冠白色，花數甚多而密生於枝端，花為圓錐花序頂生，花瓣有長柄，邊緣皺曲像衣裙的花邊花絲長短不一。果實為蒴果，橢圓形約6-8公厘，種子有翅。","F_Pic02_ALT":null,"F_Family":"千屈菜科 Lythraceae","F_Voice03_ALT":null,"F_Voice02_URL":null,"F_Pic03_ALT":null,"F_Pic01_ALT":null,"F_CID":null,"F_pdf01_URL":null,"F_Vedio_URL":null,"F_Genus":"紫薇屬Lagerstroemia","F_Function＆Application":"1. 優良薪炭材：木質堅硬耐燒，是臺灣優良的薪炭材之一。","F_Voice03_URL":null,"F_Update":null,"_id":1}]
         */

        private int limit;
        private int offset;
        private int count;
        @SerializedName("results")
        private List<ItemPlantInfo> plantInfoList;

        public int getLimit() {
            return limit;
        }

        public int getOffset() {
            return offset;
        }

        public int getCount() {
            return count;
        }

        public List<ItemPlantInfo> getPlantInfoList() {
            return plantInfoList;
        }

        public static class ItemPlantInfo {
            /**
             * F_Name_Latin : Lagerstroemia speciosa
             * F_pdf02_ALT : null
             * F_Location : 臺灣動物區；蟲蟲探索谷；兒童動物區；熱帶雨林區；白手長臂猿島
             * F_pdf01_ALT : null
             * rank : 0.0573088
             * F_Summary :
             * F_Pic01_URL : null
             * _full_count : 20
             * F_pdf02_URL : null
             * F_Pic02_URL : null
             * F_Keywords :
             * F_Code : null
             * F_Geo : MULTIPOINT ((121.5804577 24.9979216), (121.5805328 24.9959671), (121.582185 24.9984662), (121.5836763 24.9957094), (121.5816861 24.9980966))
             * F_Pic03_URL : null
             * F_Voice01_ALT : null
             * F_AlsoKnown : 爆炸樹、大果紫薇、大葉紫薇、洋紫薇、百日紅
             * F_Voice02_ALT : null
             * F_Name_Ch : 大花紫薇
             * F_Pic04_ALT : null
             * F_Name_En : Queen lagerstroemia、Queen crape myrtle
             * F_Brief : 原產於澳洲、熱帶亞洲。生長快速，木材堅硬，耐腐力強，色紅而光亮，價值媲美柚木。
             * F_Pic04_URL : null
             * F_Voice01_URL : null
             * F_Feature : 落葉喬木，可高達25公尺，樹幹通直，樹皮光滑，呈片狀剝落。單葉對生，革質，葉呈長橢圓形，長度10~28公分，寬度5~12公分，脫落前會變紅。花朵直徑5~8公分，花瓣有6枚，長度2.5~3.5公分，接近圓形，邊緣呈不規則波浪狀，早上初開時呈紅色，傍晚轉為紫紅色。果實直徑約3.5公分，呈球形，分裂成6瓣，初生時呈綠色，成熟時轉褐色。種子扁平具有翅，有利隨風散播。
             * F_Pic02_ALT : null
             * F_Family : 千屈菜科Lythraceae
             * F_Voice03_ALT : null
             * F_Voice02_URL : null
             * F_Pic03_ALT : null
             * F_Pic01_ALT : null
             * F_CID : null
             * F_pdf01_URL : null
             * F_Vedio_URL : null
             * F_Genus : 紫薇屬Lagerstroemia
             * F_Function＆Application : 1. 園藝景觀植栽用：花大、美麗，開花時，花團錦簇，甚為壯觀。秋季滿樹金黃的葉子，常栽培於庭園供觀賞或作行道樹用。
             * F_Voice03_URL : null
             * F_Update : null
             * _id : 6
             */

            private String F_Name_Latin;
            private String F_Pic01_URL;
            private String F_AlsoKnown;
            private String F_Name_Ch;
            private String F_Name_En;
            private String F_Brief;
            private String F_Feature;
            private String F_Family;
            private String F_Genus;
            @SerializedName("F_Function＆Application")
            private String FunctionApplication;
            private String F_Update;
            private int _id;

            public String getNameLatin() {
                return F_Name_Latin;
            }

            public String getPicUrl() {
                return F_Pic01_URL == null ? "" : F_Pic01_URL;
            }

            public String getAlsoKnown() {
                return F_AlsoKnown;
            }

            public String getNameCh() {
                return F_Name_Ch;
            }

            public String getNameEn() {
                return F_Name_En;
            }

            public String getBrief() {
                return F_Brief;
            }

            public String getFeature() {
                return F_Feature;
            }

            public String getFamily() {
                return F_Family;
            }

            public String getGenus() {
                return F_Genus;
            }

            public String getFunction() {
                return FunctionApplication;
            }

            public String getUpdate() {
                return F_Update == null ? "" : F_Update;
            }

            public int getId() {
                return _id;
            }
        }
    }
}
