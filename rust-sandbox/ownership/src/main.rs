fn main() {
    let s = String::from("hello");
    takes_ownership(s);     // s's value moves into the function, so it is no longer valid after this point

    let x = 5;
    makes_copy(x);   // x would move into the function, but i32 is Copy, so it's still valid to use it afterwards

    let s1 = gives_ownership();
    let s2 = String::from("hello");     // s2 comes into scope
    let s3 = takes_and_gives_back(s2);      // s2 is moved into takes_and_gives_back, which also moves its return value into s3

    
}  // s1 and s3 go out of scope and are dropped.  s2 also goes out of scope but was moved, so nothing happens.

fn takes_ownership(some_string: String) {
    println!("{}", some_string);
}  // some_string goes out of scope here - because it resided on the heap, `drop` is called and the backing memory is freed

fn makes_copy(some_integer: i32) {
    println!("{}", some_integer);
} // some_integer goes out of scope here - because it resided on the stack, nothing happens.

fn gives_ownership() -> String {
    let some_string = String::from("hello");
    some_string     // some_string is returned and moves out to the calling function
}

fn takes_and_gives_back(a_string: String) -> String {   // a_string comes into scope
    a_string    // a_string is returned and moves out to the calling function
}
