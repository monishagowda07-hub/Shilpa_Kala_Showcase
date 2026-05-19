package com.monisha.shilpakalaapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.net.URLEncoder

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GalleryScreen()
                }
            }
        }
    }
}

// DATA MODEL
data class ArtItem(
    val id: String,
    val image: Int,
    val title: String,
    val description: String,
    val timeline: List<String>
)

// DATA LIST
val artList = listOf(

    ArtItem(
        "A101",
        R.drawable.art1,
        "Ganesha Idol",
        "A beautifully crafted Ganesha idol symbolizing wisdom and prosperity.",
        listOf(
            "Stone Selection",
            "Rough Shaping",
            "Detail Carving",
            "Polishing"
        )
    ),

    ArtItem(
        "A102",
        R.drawable.art2,
        "Shiva Statue",
        "A Shiva statue representing peace and divine energy.",
        listOf(
            "Block Selection",
            "Face Shaping",
            "Hair Carving",
            "Finishing"
        )
    ),

    ArtItem(
        "A103",
        R.drawable.art3,
        "Temple Sculpture",
        "Intricate temple wall carving showing mythological scenes.",
        listOf(
            "Surface Preparation",
            "Sketch Design",
            "Layer Carving",
            "Detailing"
        )
    ),

    ArtItem(
        "A104",
        R.drawable.art4,
        "Nandi Statue",
        "Sacred Nandi sculpture symbolizing devotion and strength.",
        listOf(
            "Base Carving",
            "Body Shaping",
            "Ornament Detailing",
            "Polishing"
        )
    ),

    ArtItem(
        "A105",
        R.drawable.art5,
        "Lakshmi Idol",
        "Goddess Lakshmi idol representing wealth and prosperity.",
        listOf(
            "Base Design",
            "Face Carving",
            "Jewelry Detailing",
            "Finishing"
        )
    ),

    ArtItem(
        "A106",
        R.drawable.art6,
        "Durga Sculpture",
        "Powerful Durga sculpture showing strength and protection.",
        listOf(
            "Structure Carving",
            "Weapon Design",
            "Facial Detail",
            "Polish"
        )
    ),

    ArtItem(
        "A107",
        R.drawable.art7,
        "Krishna Idol",
        "Graceful Krishna idol playing flute symbolizing love.",
        listOf(
            "Body Shape",
            "Flute Carving",
            "Ornaments",
            "Finishing"
        )
    ),

    ArtItem(
        "A108",
        R.drawable.art8,
        "Hanuman Statue",
        "Hanuman sculpture representing devotion and courage.",
        listOf(
            "Body Carving",
            "Face Detailing",
            "Weapon Design",
            "Polish"
        )
    ),

    ArtItem(
        "A109",
        R.drawable.art9,
        "Stone Carving Art",
        "Decorative stone carving showing artistic patterns.",
        listOf(
            "Pattern Design",
            "Rough Carving",
            "Detailing",
            "Finish"
        )
    ),

    ArtItem(
        "A110",
        R.drawable.art10,
        "Temple Pillar",
        "Beautiful temple pillar reflecting ancient architecture.",
        listOf(
            "Shape Design",
            "Pattern Marking",
            "Deep Carving",
            "Polish"
        )
    ),

    ArtItem(
        "A111",
        R.drawable.art11,
        "Wood Carving",
        "Traditional wood carving with detailed craftsmanship.",
        listOf(
            "Wood Selection",
            "Cutting",
            "Design Carving",
            "Polish"
        )
    ),

    ArtItem(
        "A112",
        R.drawable.art12,
        "Heritage Sculpture",
        "Ancient-style sculpture preserving Indian heritage.",
        listOf(
            "Concept Design",
            "Structure Build",
            "Detailing",
            "Finishing"
        )
    ),

    ArtItem(
        "A113",
        R.drawable.art13,
        "Traditional Idol",
        "Classic idol created using traditional carving techniques.",
        listOf(
            "Base Carving",
            "Shape Design",
            "Detailing",
            "Polish"
        )
    ),

    ArtItem(
        "A114",
        R.drawable.art14,
        "Ancient Carving",
        "Historic carving inspired by ancient temples.",
        listOf(
            "Surface Work",
            "Pattern Engraving",
            "Detailing",
            "Finish"
        )
    ),

    ArtItem(
        "A115",
        R.drawable.art15,
        "Indian Sculpture",
        "Authentic Indian sculpture reflecting rich culture.",
        listOf(
            "Concept Design",
            "Carving",
            "Detailing",
            "Polish"
        )
    ),

    ArtItem(
        "A116",
        R.drawable.art16,
        "Decor Stone Art",
        "Modern decorative stone art for interior designs.",
        listOf(
            "Design",
            "Stone Cutting",
            "Carving",
            "Finishing"
        )
    ),

    ArtItem(
        "A117",
        R.drawable.art17,
        "Temple Hampi",
        "Architecture inspired by Hampi temple carvings.",
        listOf(
            "Structure Design",
            "Detailing",
            "Carving",
            "Finish"
        )
    ),

    ArtItem(
        "A118",
        R.drawable.art18,
        "Religious Art",
        "Spiritual artwork representing divine traditions.",
        listOf(
            "Concept",
            "Symbol Carving",
            "Detailing",
            "Finish"
        )
    ),

    ArtItem(
        "A119",
        R.drawable.art19,
        "Classic Idol",
        "Timeless idol design with balanced proportions.",
        listOf(
            "Base Shape",
            "Symmetry Design",
            "Detailing",
            "Polish"
        )
    ),

    ArtItem(
        "A120",
        R.drawable.art20,
        "Handcrafted Art",
        "Carefully handcrafted sculpture showing artistic skill.",
        listOf(
            "Material Selection",
            "Manual Carving",
            "Detailing",
            "Finish"
        )
    )
)

@Composable
fun GalleryScreen() {

    var selectedItem by remember { mutableStateOf<ArtItem?>(null) }
    var searchText by remember { mutableStateOf("") }

    val filteredList = artList.filter {
        it.title.contains(searchText, ignoreCase = true)
    }

    if (selectedItem == null) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {

            item(span = { GridItemSpan(2) }) {

                Column {

                    Text(
                        text = "Shilpa Kala Showcase",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        label = { Text("Search Sculpture...") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            items(filteredList) { item ->

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            selectedItem = item
                        },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {

                    Column {

                        AsyncImage(
                            model = item.image,
                            contentDescription = item.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                        )

                        Text(
                            text = item.title,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }

    } else {

        DetailScreen(
            item = selectedItem!!,
            onBack = {
                selectedItem = null
            }
        )
    }
}

@Composable
fun DetailScreen(
    item: ArtItem,
    onBack: () -> Unit
) {

    val context = LocalContext.current
    var isZoomed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "← Back",
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable {
                    onBack()
                }
        )

        AsyncImage(
            model = item.image,
            contentDescription = item.title,
            contentScale = if (isZoomed) {
                ContentScale.Fit
            } else {
                ContentScale.Crop
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(if (isZoomed) 400.dp else 250.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable {
                    isZoomed = !isZoomed
                }
        )

        Text(
            text = "(Tap image to zoom)",
            color = Color.Gray
        )

        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 12.dp)
        )

        Text(
            text = "About this Art",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(text = item.description)

        Text(
            text = "Work Process",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        item.timeline.forEach { step ->
            Text(text = "🔹 $step")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val message = URLEncoder.encode(
                    "Hello, I am interested in ${item.title} (ID: ${item.id})",
                    "UTF-8"
                )

                val url =
                    "https://wa.me/918904854969?text=$message"

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )

                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Enquire on WhatsApp")
        }
    }
}