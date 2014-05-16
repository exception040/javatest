SubtitleFixer
=============


This program takes a subtitle file for a movie and adjusts it +-n seconds to make the subtitles match the video.

A subtitle file is nothing more than a text file.   For example, here are the first few seconds of the movie Despicable Me in Spanish:

 

1

00:02:43,207 --> 00:02:45,641

Perdón, ¿dónde está el váter?

 

2

00:02:54,487 --> 00:02:55,886

¡Justin!

 

3

00:02:55,967 --> 00:02:58,879

Venga, cariño, sácame una foto.

Estoy levantando la pirámide.

 

4

00:03:07,687 --> 00:03:09,723

¡Justin, vuelve aquí ahora mismo!

 

5

00:03:10,127 --> 00:03:11,116

¡No! ¡Para!

 

As you can see, the subtitles have there elements:

1)      The subtitle line number

2)      The time to start and end displaying the subtitle. This is in hh:mm:ss,xxx format where xxx is miliseconds

3)      The subtitle itself

If you download a movie and the subtitles do not match the movie then you need to add or subtract seconds to the subtitle to make it match. In VLCPlayer this is easy. Just look at the bottom of the screen. It will show you the time down to the second. You can then figure out whether your movie is ahead or behind the subtitles. Use ths program to add or subject that number of seconds to the subtitle file to fix that.


 

Here is the batch file illustrating how to use it.

 

java -cp subtitles.jar com.spr.subtitles.SubtitleFixed c:\\subtitlefixer\\in.srt 71 c:\\subtitlefixer\\out.srt
