function externallinks() {

    if (!document.getElementsByTagName) return;

    var anchors = document.getElementsByTagName("A");
    alert("执行了此JS文件");
    for (var i = 0; i < anchors.length; i++) {

        var anchor = anchors[i];

        if (anchor.getAttribute("href") &&

anchor.getAttribute("rel") == "external")

            anchor.target = "_blank";

    }

}