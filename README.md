# UpdaterAPI

UpdaterAPI is a useful Java API for creating a simple Auto-Updater. Its downloading a jar file from a custom url and replace it.
---
How it works:

1. Implement the UpdaterAPI class in your Java program (See [here](#work-with-the-api))
2. After starting your Java program it will download the Updater (See [here](#download-the-updaterapi))
3. Your program starts the downloaded Updater jar before its closing (See [here](#update-with-the-updaterapi))
4. The Updater downloading the newest Jar from your Website
5. The Updater replaces the new Jar with the old
6. And done!

# Work with the API

Here we use the [UpdaterAPI](https://github.com/ZeusSeinGrossopa/UpdaterAPI/blob/master/src/test/java/UpdaterAPI.java)
class. You need to implement this class in your Java program. The UpdaterAPI uses
the [Gson](https://github.com/google/gson) &
the [Apache-Commons-IO](https://github.com/apache/commons-io) library's. These librarys you must implement too in your
program

### Download the UpdaterAPI

```
public void start() {
     UpdaterAPI.downloadUpdater(new File("./Updater.jar"));
}

```

### Update with the UpdaterAPI

```
public void update() {
    File newFile = new File("./YourProgram.jar");
    String url = "www.yoururl.com/api/yourprogram/v1.0/YourProgram.jar";

    try {
        UpdaterAPI.update(url, newFile);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

### Other functions

- Use `UpdaterAPI.setAutoDelete(true)` that the Updater is only available in the directory, when the program has a new
  version to
  update. Default is that the updater is always available in the folder.

# Run parameters

1. This parameter is the url from where the Updater downloads the latest file of your program. (for
   example: www.yoururl.com/api/yourprogram/v1.0/YourProgram.jar)
2. Your file of the program what you want to replace (Must be a absoult path)
3. The new Path location of your program what you want to replace (Must be a absoult path)
4. (Optional) With the 4. parameter you can restart the jar file

---

![logo_white_large](https://user-images.githubusercontent.com/80217114/157707596-ddf31272-8360-4356-8ed6-405ce45e536c.png)
