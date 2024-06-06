# List view
- Generates an scrolleable view.
- Currently is a legacy component.
- RecycleView replace it. 

## Adapters and list views
- A bridge between the UI and data source. Similar to a controller

### Array adapter
- An adapter prebuild by android
- Based on arrays. 
Example: 

- Put a listView to the MainActivity.xml (remember is a legacy item)
```kotlin
listView = findViewById(R.id.listView)
var items = arrayOf("Item 1", "Item 2", "Item 3")
var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
listView.adapter = adapter
```

### Custom Adapter
On a class we need to create 
- override getCount()
- override getItem()
- override getItemId()
- override getView()

Example
- Generate a `listview_call_layout.xml` and put an id `listview_cell_layout` with a TextView. 
- 

```kotlin
class MyListViewAdapter(val context: Context, val item: List<String>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int) {
        return items[position] 
    }

    override fun getItemId(position: Int) {
        return position.toLog() // Sets the item Id for each item on the array
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater // Converts a .xml to a usable view on this code.

            view = inflater.inflate(R.layout.listview_cell_layout, parent, false)
        } else {
            view = convertView
        }

        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = getItem(position) as String
        return view 
    }
}
```
