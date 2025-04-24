

I ran into a few issues while working on these tasks.
In Task 2 I spent quite a bit of time with Java’s package-to-folder mapping—my classes weren’t being found by the compiler until 
I finally realized that my directory tree had to exactly match the `package` lines in `A21.java`, `A22.java`, 
and my new `R21.java`. Once I reshaped `src/muhammad_ahmed_1/midterm1/t2/...` to nested folders (`vinegar/sub`, `knife/opera`, etc.) 
and marked `src` as the source root in my IDE, everything compiled and ran cleanly. For Task 3,
matching the look and feel of the sample PDF in Markdown took a few iterations—I tweaked headings,
code-block fences, and spacing until the `.md` version felt as close as possible to the original guide.

Throughout both tasks I leaned on AI to speed things up. 
ChatGPT helped me draft the directory-structure explanation, suggested the `switch`-case for month names
in `R21`, and gave me a solid starting point for the Markdown layout. When I needed random 
professor-and-course names for the demo, AI spit out plausible pairs in seconds
In short, AI was great at boilerplate: code skeletons, folder mappings, and doc formatting.

I built the LMS in a single Java file (`LMS.java`) to stay fast and
lightweight. Using basic collections (`Map`, `List`) I added three
tiny inner classes—**Student**, **Course** (with capacity limits), and a **GradeBook** block
for the *new-feature* grade tracking. A simple console menu driven by a `Scanner` lets you register students
create courses, enrol them, record marks, and print a brief grade report with an average. 
