override fun onWidgetChanged(smartspacerId: String, remoteViews: RemoteViews?) {
    //Load the RemoteViews into regular Views
    val views = remoteViews?.load() ?: return
    //Find a ImageView with the ID of "image", belonging to package "com.example"
    val imageView = views.findViewByIdentifier<ImageView>("com.example:id/image")
    if(imageView != null){
        val image = imageView.drawable.toBitmap()
        //Do something with the image
    }else{
        Log.e("ExampleWidgetProvider", "Failed to load image from widget!")
    }
}views.dumpToLog("Views")val listView = views.findViewsByType(ListView::class.java).firstOrNull()structure.getViewIdFromStructureId(IDENTIFIER_LIST)structure.getViewIdFromStructureId(IDENTIFIER_LIST)https://workspace.google.com/business/signup/bring?utm_source=gwslearningcenter&utm_medium=support&utm_campaign=13054147


adb shell sh /storage/emulated/0/Android/data/moe.shizuku.privileged.api/start.sh
blurhash-python==1.2.2
IKO-Patcher-Tester
==================
