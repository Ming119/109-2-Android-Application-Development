### Question 1
Which two layout constraint attributes on the **Zero** `Button` position it vertically equal distance between the other two `Button` elements? (Pick 2 answers.)

- [x] `app:layout_constraintBottom_toTopOf="@+id/button_count"`
- [ ] `android:layout_marginBottom="8dp"`
- [ ] `android:layout_marginStart="16dp"`
- [x] `app:layout_constraintTop_toBottomOf="@+id/button_toast"`
- [ ] `android:layout_marginTop="8dp"`

### Question 2
Which layout constraint attribute on the **Zero** `Button` positions it horizontally in alignment with the other two `Button` elements?

- [x] `app:layout_constraintLeft_toLeftOf="parent"`
- [ ] `app:layout_constraintBottom_toTopOf="@+id/button_count"`
- [ ] `android:layout_marginBottom="8dp"`
- [ ] `app:layout_constraintTop_toBottomOf="@+id/button_toast"`

### Question 3
What is the correct signature for a method used with the `android:onClick` XML attribute?

- [ ] `public void callMethod()`
- [x] `public void callMethod(View view)`
- [ ] `private void callMethod(View view)`
- [ ] `public boolean callMethod(View view)`

### Question 4
The click handler for the **Count** `Button` starts with the following method signature:

> public void countUp(View view)

Which of the following techniques is more efficient to use within this handler to change the `Button` element's background color? Choose one:

- [ ] Use `findViewById` to find the Count `Button`. Assign the result to a View variable, and then use `setBackgroundColor()`.
- [x] Use the `view` parameter that is passed to the click handler with `setBackgroundColor()`: `view.setBackgroundColor()`
