# Recycler View
- An improved version of GridView and ListView. 
    - Is more efficient than both Views. 
    - Can have the same functionality ad a ListView and a GridView

### RecycleView Adapter
- Its a generic type. 
- The generic param should be a class that extends from ViewHolder (better be a inner class)

Example: 
- Create a `.xml` activity and add a `RecyclerView`, put an id. 

```kotlin
// MainActivity.k
lateinit var listView : ListView

override fun onCreate() {
    ...
    recyclerView = findViewById(R.id.rView )
    var people = listOf<String>(Person("John", "Cena"), Person("Juan", "Perez"), ... )
    recyclerView.adapter = RVAdapter(people)
    recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false) // Tells how to show the items
}
```

- Create a class Person
```kotlin
data class Person(val name: String, val lastNAme, String)
```

- Create a `layout.xml` and generate a layout to use on the adapter.

- Create a class RVAdapter
```kotlin
class RVAdapter(val people: List<Person>): RecyclerView.Adapter<RVAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView
        var lastnameTextView: TextView
        var imageView: ImageView

        init {
            nameTextView = itemView.findViewById(R.id.textView)
            lastNameTextView = itemView.findViewById(R.id.textView2)
            imageView = itemView.findViewById(R.id.innerView) 
        }
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onCreateNewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_id, parent, false)
        val viewHolder = MyViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = people(position)
        holder.nameTextView.text = item.name
        holder.lastNameTextView.text = item.lastName

    }
}
```

## Layout Managers
- Grid
- Staggerred Grid
- List


