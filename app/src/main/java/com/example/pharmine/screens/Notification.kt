package com.example.pharmine.screens

//import android.app.Notification
//import android.app.Notification.EXTRA_NOTIFICATION_ID
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.os.Build
//import android.provider.Settings.Global.getString
//import androidx.core.app.NotificationCompat
//import androidx.core.content.ContextCompat.getSystemService
//
//var builder = NotificationCompat.Builder(this, CHANNEL_ID)
//    .setSmallIcon() // small icon upload
//    .setContentTitle("My Notification")
//    .setContentText("My much longer text that cannot fit in one line....")
//    .setContentStyle(Notification.BigTextStyle().bigText("My much longer text that cannot fit in one line...."))
//    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//private fun createNotificationChannel() {
//    // only support for devices above api26
//    if(Build.VERSION.SDK_ >= Build.VERSION_CODES.O) {
//        val name = getString()  // input name of channel
//        val descriptionText = getString()       // input channel description
//        val importance = NotificationManager.IMPORTANCE_DEFAULT
//        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply{description = descriptionText}
//        // Register the channel with the system
//        val notificationManager: NotificationManager =
//            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(channel)
//    }
//}
//
//// create explicit intent fon an activity in app
//val intent = Intent(this, AlertDetails::class.java).apply {
//    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//}
//
//val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
//
//val builder = NotificationCompat.Builder(this, CHANNEL_ID)
//    .setSmallIcon()     // set small icon
//    .senContentTitle("My Notification")
//    .setContentText("Hello World!")
//    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//    // set the intent that will fire when user taps notification
//    .setContentIntent(pendingIntent)
//    .setAutoCancel(true)
//
//with(NotificationManagerCompat.from(this)) {
//    // notificationId is a unique int for each notification that you must define
//    notify(notificationId, builder.build())
//}
//
//
//val snoozeIntent = Intent(this, MyBroadcastReceiver::class.java).apply {
//    action = ACTION_SNOOZE
//    putExtra(EXTRA_NOTIFICATION_ID, 0)
//}
//val snoozePendingIntent: PendingIntent =
//    PendingIntent.getBroadcast(this, 0, snoozeIntent, 0)
//val builder = NotificationCompat.Builder(this, CHANNEL_ID)
//    .setSmallIcon()     // set small icon
//    .setContentTitle("My notification")
//    .setContentText("Hello World!")
//    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//    .setContentIntent(pendingIntent)
//    .addAction(, getString(),
//        snoozePendingIntent)