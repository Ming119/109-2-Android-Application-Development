### Question 1
Which constructor method do you use to create an implicit `Intent` to launch a camera app?
- [ ] `new Intent()`
- [x] `new Intent(Context context, Class<?> class)`
- [ ] `new Intent(String action, Uri uri)`
- [ ] `new Intent(String action)`

### Question 2
When you create an implicit `Intent` object, which of the following is true?
- [ ] Don't specify the specific `Activity` or other component to launch.
- [ ] Add an `Intent` action or `Intent` categories (or both).
- [ ] Resolve the `Intent` with the system before calling `startActivity()` or `startActivityforResult()`.
- [x] All of the above.

### Question 3
Which `Intent` action do you use to take a picture with a camera app?
- [ ] `Intent takePicture = new Intent(Intent.ACTION_VIEW);`
- [ ] `Intent takePicture = new Intent(Intent.ACTION_MAIN);`
- [x] `Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);`
- [ ] `Intent takePicture = new Intent(Intent.ACTION_GET_CONTENT);`
