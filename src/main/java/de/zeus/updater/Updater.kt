package de.zeus.updater

import java.io.File
import kotlin.jvm.JvmOverloads
import org.apache.commons.io.FilenameUtils
import org.apache.commons.io.FileUtils
import java.io.IOException
import java.io.BufferedReader
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonElement
import java.lang.RuntimeException
import java.util.function.Supplier
import kotlin.Throws
import java.lang.NullPointerException
import java.lang.ProcessBuilder
import java.net.URISyntaxException
import kotlin.jvm.JvmStatic
import java.lang.InterruptedException
import de.zeus.updater.Updater
import java.lang.Boolean
import java.net.URL
import kotlin.system.exitProcess

object Updater {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        if (args.size < 3) {
            println("Updater must be run with three arguments!")
            return
        }
        val url = args[0]
        val oldName = args[1]
        val newName = args[2]
        var restart = false
        if (args.size == 4) {
            restart = Boolean.parseBoolean(args[3])
        }
        if (url.isEmpty()) {
            println("URL empty!")
            return
        }
        if (oldName.isEmpty()) {
            println("OldName empty!")
            return
        }
        if (newName.isEmpty()) {
            println("NewName empty!")
            return
        }

//        File oldFile = new File("./" + oldName);
//        File newFile = new File("./" + newName);
        val oldFile = File(oldName)
        val newFile = File(newName)
        if (oldFile.exists()) oldFile.delete()
        downloadFile(url, newFile)
        if (restart) {
            val javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java"
            val builder = ProcessBuilder(javaBin, "-jar", newFile.absolutePath)
            try {
                builder.start()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        exitProcess(0)
    }

    private fun downloadFile(url: String?, destination: File?) {
        try {
            FileUtils.copyURLToFile(URL(url), destination)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}