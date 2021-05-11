### Question 1
For a `ProgressBar`:
How do you determine the range of values that a `ProgressBar` can show?
> Set integer values for `android:min` and `android:max` attributes.

How do you change how much of the progress bar is filled in?
> Set integer value for `android:progress` attribute.



### Question 2
If an `AsyncTask` is defined as follows:
```java
private class DownloadFilesTask extends AsyncTask<URL, Integer, Long>
```

What is the type of the value that is passed to `doInBackground()` in the AsyncTask?
> URL

What is the type of the value that is passed to the callback that reports the progress of the task?
> Integer

What is the type of the value that is passed to the callback that is executed when the task completes?
> Long



### Question 3
To report progress of the work executed by an `AsyncTask`, what callback method do you implement, and what method do you call in your AsyncTask subclass?
- [ ] Implement `publishProgress()`. Call `publishProgress()`.
- [ ] Implement `publishProgress()`. Call `onProgressUpdate()`.
- [x] Implement `onProgressUpdate()`. Call `publishProgress()`.
- [ ] Implement `onProgressUpdate()`. Call `onProgressUpdate()`.
