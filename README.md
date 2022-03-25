# UpdaterAPI

UpdaterAPI is a useful API for creating a simple Auto-Updater. Its downloading files from a url and replacing it.
---
How it works:

1. Your program downloads the Updater (See [here](#Download the UpdaterAPI))
2. Your program running the jar before its closing (See [here](#Update with the UpdaterAPI))
3. The Updater downloading the newest Jar from your Website
4. The Updater replaces the new Jar with the old
5. And done!

# Work with the API

Here we use the [UpdaterAPI](https://github.com/ZeusSeinGrossopa/UpdaterAPI/blob/master/src/test/java/UpdaterAPI.java)
class. The UpdaterAPI uses the [Gson](https://github.com/google/gson) &
the [Apache-Commons-IO](https://github.com/apache/commons-io) library's

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

### Other uses

- Use `UpdaterAPI.setAutoDelete(true)` that the Updater is only show up in the directory, when the program needs to
  update

# Run parameter

1. URL. This parameter is the url from where the Updater downloads the latest file of your program. (for
   example: www.yoururl.com/api/yourprogram/v1.0/YourProgram.jar)
2. Your file of the program what you want to replace (Must be a absoult path)
3. The new Path location of your program what you want to replace (Must be a absoult path)
4. (Optional) With the 4. parameter you can restart the jar file

---

![logo_white_large](https://user-images.githubusercontent.com/80217114/157707596-ddf31272-8360-4356-8ed6-405ce45e536c.png)
