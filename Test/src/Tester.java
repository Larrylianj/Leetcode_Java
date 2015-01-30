import java.util.*;
class Node{
    int x;
    int y;
    Node(int a, int b){
        x = a;
        y = b;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
class Point {
	 int x;
	 int y;
	 Point() { x = 0; y = 0; }
	 Point(int a, int b) { x = a; y = b; }
}
public class Tester {

	
	class Line{
        double k;
        double b;
        boolean xp;
        int xValue;
        Line(double m, double n){
            k = m;
            b = n;
            xp = false;
            xValue = 0;
        }
        Line(int v){
            k = Integer.MAX_VALUE;
            b = 0;
            xp = true;
            xValue = v;
        }
        @Override
        public int hashCode(){
            return (int)Math.round(k) << 16|(int)Math.round(b) + xValue;
        }
        @Override
        public boolean equals(Object o){
            if(o == this)
                return true;
            if(!(o instanceof Line))
                return false;
            Line l = (Line)o;
            if(xp && l.xp)
                return xValue==l.xValue;
            else
                return Math.abs(k-l.k) < zero && Math.abs(b-l.b) < zero;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char[][] b ={{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','3','.','.'},{'.','.','.','1','8','.','.','.','.'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','.','1','.','9','7','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','3','6','.','1','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','2','.'}};
//		char[][] b ={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','4','1','9','2','8','.'},{'.','.','.','.','8','.','.','.','5'},{'.','.','.','.','.','.','.','7','9'}};
		Tester t = new Tester();
//		String start = "red";
//		String end = "tax";
//		String[] set = {"ted","tex","tad","den","rex","pee"};
		String start = "catch";
		String end = "choir";
		String[] set = {"tours","awake","goats","crape","boron","payee","waken","cares","times","piled","maces","cuter","spied","spare","mouse","minty","theed","sprat","veins","brian","crown","years","drone","froth","foggy","laura","sears","shunt","gaunt","hovel","staff","child","arson","haber","knows","rubes","czars","pawed","whine","treed","bauer","jodie","timed","flits","robby","gooks","yawls","purse","veeps","tints","taped","raced","shaft","modes","dykes","slims","parts","emile","frail","salem","jives","heave","bayer","leech","clipt","yanks","wilds","hikes","cilia","spiel","mulls","fetal","homed","drown","suite","defer","oaken","flail","zippy","burke","slued","mowed","manes","verse","serra","bruno","spoke","mikes","hafts","breed","sully","croce","boers","chair","thong","pulse","pasta","perot","fices","shies","nadir","every","diets","roads","cones","tuned","globs","graft","stall","royal","fixes","north","pikes","slack","vests","quart","crawl","tangs","calks","mayor","filmy","barns","block","hoods","storm","cedes","emote","tacks","skirt","horsy","mawed","moray","wring","munch","hewed","hooke","batch","drawl","berth","sport","welch","jeans","river","tabby","amens","stump","cause","maced","hiker","spays","dusty","trail","acorn","zooms","puked","clown","sands","kelli","stein","rawer","water","dolts","momma","fluky","scots","pupil","halls","toady","pored","latch","shags","union","tamps","stead","ryder","knoll","cacao","damns","charm","frank","draws","gowns","risen","saxes","lucks","avert","yolks","clime","wedge","ruses","famed","sabik","gravy","anion","veils","pyres","raspy","lofts","tress","showy","percy","rices","taker","roger","yeats","baked","ayers","fazes","curly","shawn","clare","paine","ranks","hocks","berta","plays","parks","tacos","onion","skeet","acton","lamer","teals","reset","steal","maven","sored","fecal","harsh","totem","swoop","rough","jokes","mires","weird","quits","damps","touts","fling","sarah","peeps","waxen","traps","mange","swell","swoon","catch","mower","bonny","finds","yards","pleas","filed","smelt","drams","vivid","smirk","whigs","loafs","opens","meter","hakes","berms","whack","donny","faint","peace","libby","yates","purer","wants","brace","razed","emend","bards","karyn","japed","fated","missy","punks","humps","steak","depth","brunt","hauls","craws","blast","broom","tones","ousts","wires","peeks","ruffs","crack","monte","worth","spans","tonic","runny","erick","singe","maine","casts","jello","realm","haste","utter","bleat","kasey","palms","solos","hoagy","sweep","loner","naves","rhine","acmes","cadet","dices","saris","mauro","fifty","prows","karat","dowel","frays","shorn","sails","ticks","train","stars","stork","halts","basal","glops","beset","rifer","layla","lathe","daffy","jinns","snide","groin","kelly","zincs","fryer","quilt","drama","shook","swami","hulls","swazi","danes","axons","those","lorry","plath","prime","faces","crock","shake","borer","droop","derek","shirk","styed","frown","jells","slows","lifts","jeers","helms","turds","dross","tired","rimes","beats","dingo","crews","bides","loins","furry","shana","wises","logos","aural","light","pings","belch","campy","swish","sangs","nerds","boggy","skies","weals","snags","joyed","mamet","miser","leaks","ramos","tract","rends","marks","taunt","sissy","lipid","beach","coves","fates","grate","gloss","heros","sniff","verve","tells","bulge","grids","skein","clout","leaps","males","surfs","slips","grave","boats","tamed","muled","meier","lower","leafy","stool","reich","rider","iring","ginny","flaks","chirp","tonga","chest","ollie","foxes","links","alton","darth","drier","sated","rails","gyros","green","jenna","cures","veals","sense","sworn","roses","aides","loses","rival","david","worms","stand","track","dales","noyes","fraud","shock","sward","pluto","biked","roans","whiny","halve","bunts","spilt","gamey","deeds","oozed","ruder","drano","sages","fewer","maize","aimed","bails","poole","hunts","shari","champ","shuns","jonah","faced","spook","harry","lagos","peale","nacho","saint","power","chaff","shard","cocky","irate","tummy","withe","forks","bates","stuns","turfs","coped","coups","vince","helps","facet","fezes","outer","cheek","tried","sumps","fakes","fonds","yearn","brays","flute","fetid","beyer","mamma","topic","bouts","trend","gorey","hills","swaps","sexes","cindy","ruler","kited","gaits","shank","cloys","stuck","purus","musks","gouge","brake","biker","layer","lilly","bills","seven","flyer","phase","wowed","beaus","cokes","chimp","spats","mooch","dried","hulks","shift","galen","wiped","clops","decal","nopes","huffs","lades","sunny","foyer","gusty","wormy","chips","focus","pails","solid","ariel","gamed","diver","vying","sacks","spout","sides","agave","bandy","scant","coils","marci","marne","swank","basil","shine","nines","clues","fuzes","jacks","robin","pyxes","later","silas","napes","homes","baled","dames","abuse","piker","coots","tiles","bents","pearl","booty","hells","dusky","glare","scale","pales","leary","scull","bimbo","mossy","apron","manet","opted","kusch","shiny","argos","hoped","towns","bilbo","slums","skull","shale","mandy","scows","speed","eager","lards","crows","merry","anted","faxed","leave","fargo","creek","comas","golda","baize","easts","plied","rared","ashed","doted","bunin","bonds","yarns","latin","right","worst","sixes","gabby","begun","upend","giant","tykes","creak","manor","bosom","riced","dimly","holes","stunt","parsi","peers","snell","mates","jules","rusty","myles","yules","sades","hobbs","booth","clean","liven","gamer","howdy","stray","riser","wisps","lubes","tubes","rodeo","bigot","tromp","pimps","reeve","pumps","dined","still","terms","hines","purrs","roast","dooms","lints","sells","swims","happy","spank","inset","meany","bobby","works","place","brook","haded","chide","slime","clair","zeros","britt","screw","ducal","wroth","edger","basie","benin","unset","shade","doers","plank","betsy","bryce","cross","roped","weans","bliss","moist","corps","clara","notch","sheep","weepy","bract","diced","carla","locks","sawed","covey","jocks","large","pasts","bumps","stile","stole","slung","mooed","souls","dupes","fairs","lined","tunis","spelt","joked","wacky","moira","strut","soled","pints","axing","drank","weary","coifs","wills","gibes","ceded","gerry","tires","crazy","tying","sites","trust","dover","bolds","tools","latex","capet","lanky","grins","brood","hitch","perts","dozes","keels","vault","laius","chung","deres","glove","corms","wafer","coons","ponce","tumid","spinx","verge","soggy","fleas","middy","saiph","payer","nukes","click","limps","oared","white","chart","nasty","perth","paddy","elisa","owing","gifts","manna","ofter","paley","fores","sough","wanda","doggy","antic","ester","swath","spoon","lamas","meuse","hotel","weedy","quads","paled","blond","flume","pried","rates","petal","rover","marsh","grief","downy","pools","buffs","dunne","cruel","finny","cosby","patch","polly","jerks","linen","cider","visas","beard","mewed","spill","trots","tares","pured","prior","build","throe","wends","baned","mario","misty","golds","lacey","slags","jived","finis","inner","money","skews","sunks","fined","bauds","lapel","class","berne","rabin","roils","hyped","styes","evans","towed","hawed","allow","modal","ports","erich","rills","humid","hooks","sedge","shirt","nippy","fundy","runes","smile","dolly","tisha","byers","goths","sousa","mimed","welts","hoots","shown","winds","drays","slams","susan","frogs","peach","goody","boned","chewy","eliza","peary","pyxed","tiled","homer","tokes","verdi","mabel","rolls","laden","loxed","phony","woods","brine","rooks","moods","hired","sises","close","slops","tined","creel","hindu","gongs","wanes","drips","belly","leger","demon","sills","chevy","brads","drawn","donna","glean","dying","sassy","gives","hazes","cores","kayla","hurst","wheat","wiled","vibes","kerry","spiny","wears","rants","sizer","asses","duked","spews","aired","merak","lousy","spurt","reeds","dared","paged","prong","deere","clogs","brier","becks","taken","boxes","wanna","corny","races","spuds","jowls","mucks","milch","weest","slick","nouns","alley","bight","paper","lamps","trace","types","sloop","devon","pedal","glint","gawky","eaves","herbs","felts","fills","naval","icing","eking","lauds","stats","kills","vends","capes","chary","belle","moats","fonts","teems","wards","bated","fleet","renal","sleds","gases","loony","paced","holst","seeds","curie","joist","swill","seats","lynda","tasks","colts","shops","toted","nuder","sachs","warts","pupal","scalp","heirs","wilma","pansy","berra","keeps","menus","grams","loots","heels","caste","hypes","start","snout","nixes","nests","grand","tines","vista","copes","ellis","narks","feint","lajos","brady","barry","trips","forth","sales","bests","hears","twain","plaid","hated","kraft","fared","cubit","jayne","heats","chums","pangs","glows","lopez","vesta","garbo","ethel","blood","roams","mealy","clunk","rowed","hacks","davit","plane","fuses","clung","fitch","serer","wives","lully","clans","kinks","spots","nooks","plate","knits","greet","loads","manic","scone","darin","pills","earth","gored","socks","fauna","ditch","wakes","savvy","quiet","nulls","sizes","diana","mayan","velds","dines","punch","bales","sykes","spiky","hover","teats","lusts","ricky","think","culls","bribe","pairs","month","cored","packs","lobes","older","hefts","faxes","cased","swain","bawdy","troop","woven","stomp","swags","beads","check","shill","broad","souse","pouch","lived","iambs","teaks","clams","outed","maxed","plain","sappy","cabal","penal","shame","budge","offed","kooks","gybed","basin","thoth","arced","hypos","flows","fetch","needs","davis","jared","bongo","added","sames","randy","tunes","jamar","smash","blows","grows","palmy","miler","chins","viola","tower","cream","molls","cello","sucks","fears","stone","leans","zions","nutty","tasha","ratty","tenet","raven","coast","roods","mixes","kmart","looms","scram","chapt","lites","trent","baron","rasps","ringo","fazed","thank","masts","trawl","softy","toils","romes","norma","teens","blank","chili","anise","truss","cheat","tithe","lawns","reese","slash","prate","comet","runts","shall","hosed","harpy","dikes","knock","strip","boded","tough","spend","coats","husky","tyree","menes","liver","coins","axles","macho","jawed","weeps","goods","pryor","carts","dumps","posts","donor","daunt","limbo","books","bowls","welds","leper","benny","couch","spell","burst","elvin","limbs","regal","loyal","gaily","blade","wheal","zests","seine","hubby","sheen","tapes","slugs","bench","lungs","pipes","bride","selma","berry","burns","skins","bowen","gills","conan","yucky","gauls","voled","crust","jerky","moans","plump","sided","disks","gleam","larry","billy","aloud","match","udder","rises","wryer","deter","cling","brisk","lever","chaps","tansy","gland","rocky","lists","joins","tubed","react","farsi","dopes","chats","olsen","stern","gully","youth","wiles","slink","cooke","arise","bores","maims","danny","rives","rusts","plots","loxes","troys","cleat","waxes","booze","haven","dilly","shaun","gasps","rains","panda","quips","kings","frets","backs","arabs","rhino","beets","fiber","duffy","parry","sever","hunks","cheap","beeps","fifes","deers","purls","hello","wolfs","stays","lands","hawks","feels","swiss","tyros","nerve","stirs","mixed","tombs","saves","cater","studs","dorky","cinch","spice","shady","elder","plato","hairs","newts","slump","boots","lives","walls","spunk","bucks","mined","parch","disco","newel","doris","glues","brawn","abner","piked","laxes","bulky","moran","cozen","tinge","dowry","snare","sagan","harms","burch","plows","sunni","fades","coach","girls","typed","slush","saver","bulls","grass","holed","coven","dukes","ocher","texan","cakes","gilts","jenny","salon","divas","maris","costs","sulla","lends","gushy","pears","teddy","huffy","sited","rhone","euler","solve","grace","snarl","taste","sally","allay","suers","bogey","pooch","songs","cameo","molts","snipe","cargo","forge","reins","hoses","crams","fines","tings","wings","spoor","twice","waxed","mixer","bongs","stung","gages","yelps","croci","corks","bolls","madge","honer","riled","camus","trick","bowed","overt","steed","ripes","stave","crick","great","scott","scald","point","finch","bulks","chant","kiddo","cover","drunk","sered","dicky","wider","saith","mutts","blind","lyres","sized","darby","rebel","zones","title","yawns","laths","sting","taine","paris","route","livia","roots","belay","daubs","spoof","camel","colds","foist","saned","doles","slays","woody","leads","stout","caper","erika","lance","earns","vines","mercy","antis","terri","messy","lords","shims","serfs","jinni","caged","threw","rainy","bumpy","arias","wails","romeo","gorge","dolls","risks","skyed","fumes","payed","mites","choir","piles","scene","flake","solon","brahe","bikes","dawes","goofs","payne","cried","slavs","hives","snack","cribs","aways","fired","swarm","pumas","paved","smith","gooey","liefs","safer","banes","slake","doled","dummy","gazed","heaps","loped","scoff","crash","balmy","hexed","lunch","guide","loges","alien","rated","stabs","whets","blest","poops","cowls","canes","story","cunts","tusks","pinto","scats","flier","chose","brute","laked","swabs","preps","loose","merle","farms","gapes","lindy","share","floes","scary","bungs","smart","craps","curbs","vices","tally","beret","lenny","waked","brats","carpi","night","junes","signs","karla","dowdy","devil","toned","araby","trait","puffy","dimer","honor","moose","synch","murks","doric","muted","quite","sedan","snort","rumps","teary","heard","slice","alter","barer","whole","steep","catty","bidet","bayes","suits","dunes","jades","colin","ferry","blown","bryon","sways","bayed","fairy","bevel","pined","stoop","smear","mitty","sanes","riggs","order","palsy","reels","talon","cools","retch","olive","dotty","nanny","surat","gross","rafts","broth","mewls","craze","nerdy","barfs","johns","brims","surer","carve","beers","baker","deena","shows","fumed","horde","kicky","wrapt","waits","shane","buffy","lurks","treat","savor","wiper","bided","funny","dairy","wispy","flees","midge","hooch","sired","brett","putty","caked","witch","rearm","stubs","putts","chase","jesus","posed","dates","dosed","yawed","wombs","idles","hmong","sofas","capek","goner","musts","tangy","cheer","sinks","fatal","rubin","wrest","crank","bared","zilch","bunny","islet","spies","spent","filth","docks","notes","gripe","flair","quire","snuck","foray","cooks","godly","dorms","silos","camps","mumps","spins","cites","sulky","stink","strap","fists","tends","adobe","vivas","sulks","hasps","poser","bethe","sudan","faust","bused","plume","yoked","silly","wades","relay","brent","cower","sasha","staci","haves","dumbs","based","loser","genes","grape","lilia","acted","steel","award","mares","crabs","rocks","lines","margo","blahs","honda","rides","spine","taxed","salty","eater","bland","sweat","sores","ovens","stash","token","drink","swans","heine","gents","reads","piers","yowls","risky","tided","blips","myths","cline","tiers","racer","limed","poled","sluts","chump","greek","wines","mangy","fools","bands","smock","prowl","china","prove","oases","gilda","brews","sandy","leers","watch","tango","keven","banns","wefts","crass","cloud","hunch","cluck","reams","comic","spool","becky","grown","spike","lingo","tease","fixed","linda","bleep","funky","fanny","curve","josie","minds","musty","toxin","drags","coors","dears","beams","wooer","dells","brave","drake","merge","hippo","lodge","taper","roles","plums","dandy","harps","lutes","fails","navel","lyons","magic","walks","sonic","voles","raped","stamp","minus","hazel","clods","tiffs","hayed","rajah","pared","hates","makes","hinds","splay","flags","tempe","waifs","roved","dills","jonas","avers","balds","balks","perms","dully","lithe","aisha","witty","ellie","dived","range","lefty","wined","booby","decor","jaded","knobs","roded","moots","whens","valet","talks","blare","heeds","cuing","needy","knees","broke","bored","henna","rages","vises","perch","laded","emily","spark","tracy","tevet","faith","sweet","grays","teams","adder","miffs","tubae","marin","folds","basis","drugs","prick","tucks","fifth","treks","taney","romps","jerry","bulgy","anton","codes","bones","quota","turns","melts","croat","woken","wried","leash","spacy","bless","lager","rakes","pukes","cushy","silks","auden","dotes","hinge","noisy","coked","hiked","garth","natty","novel","peeve","macaw","sloth","warns","soles","lobed","aimee","toads","plugs","chasm","pries","douse","ruled","venus","robes","aglow","waves","swore","strum","stael","seeps","snots","freed","truck","hilly","fixer","rarer","rhyme","smugs","demos","ships","piped","jumpy","grant","dirty","climb","quell","pulps","puers","comte","kirks","waver","fever","swear","straw","serum","cowed","blent","yuppy","ropes","conks","boozy","feeds","japes","auger","noons","wench","tasty","honed","balms","trams","pasha","mummy","tides","shove","shyer","trope","clash","promo","harem","never","humus","burks","plans","tempi","crude","vocal","lames","guppy","crime","cough","rural","break","codex","baggy","camry","muses","exile","harte","evens","uriel","bombs","wrens","goren","clark","groom","tinny","alias","irwin","ruddy","twins","rears","ogden","joker","shaky","sodas","larch","lelia","longs","leeds","store","scars","plush","speck","lamar","baser","geeky","wilda","sonny","gummy","porch","grain","testy","wreck","spurs","belie","ached","vapid","chaos","brice","finks","lamed","prize","tsars","drubs","direr","shelf","ceres","swops","weirs","vader","benet","gurus","boors","mucky","gilds","pride","angus","hutch","vance","candy","pesky","favor","glenn","denim","mines","frump","surge","burro","gated","badge","snore","fires","omens","sicks","built","baits","crate","nifty","laser","fords","kneel","louse","earls","greed","miked","tunic","takes","align","robed","acres","least","sleek","motes","hales","idled","faked","bunks","biped","sowed","lucky","grunt","clear","flops","grill","pinch","bodes","delta","lopes","booms","lifer","stunk","avery","wight","flaps","yokel","burgs","racks","claus","haled","nears","finns","chore","stove","dunce","boles","askew","timid","panic","words","soupy","perks","bilge","elias","crush","pagan","silts","clive","shuck","fulls","boner","claws","panza","blurb","soaks","skips","shape","yells","raved","poppy","lease","trued","minks","estes","aisle","penes","kathy","combo","viper","chops","blend","jolly","gimpy","burma","cohan","gazer","drums","gnaws","clone","drain","morns","wages","moths","slues","slobs","warps","brand","popes","triad","ounce","stilt","shins","greer","hodge","minos","tweed","sexed","alger","floss","timer","steve","birch","known","aryan","hedge","fully","jumps","bites","shots","curer","board","lenin","corns","dough","named","kinda","truce","games","lanes","suave","leann","pesos","masks","ghats","stows","mules","hexes","chuck","alden","aping","dives","thurs","nancy","kicks","gibed","burly","sager","filly","onset","anons","yokes","tryst","rangy","pours","rotes","hided","touch","shads","tonya","finer","moors","texas","shoot","tears","elope","tills"};
//		String start = "charge";
//		String end = "comedo";		
//		String[] set = {"shanny","shinny","whinny","whiney","shiver","sharer","scarer","scaler","render","fluxes","teases","starks","clinks","messrs","crewed","donner","blurts","bettye","powell","castes","hackee","hackle","heckle","deckle","decile","defile","define","refine","repine","rapine","ravine","raving","roving","chased","roping","coping","coming","homing","pointy","hominy","homily","homely","comely","comedy","comedo","vagues","crocus","spiked","bobbed","dourer","smells","feared","wooden","stings","loafer","pleads","gaiter","meeter","denser","bather","deaves","wetted","pleats","cadger","curbed","grover","hinged","budget","gables","larked","flunks","fibbed","bricks","bowell","yonder","grimes","clewed","triads","legion","lacier","ridden","bogied","camper","damien","spokes","flecks","goosed","snorer","choked","choler","leakey","vagued","flumes","scanty","bugger","tablet","nilled","julies","roomed","ridges","snared","singes","slicks","toiled","verged","shitty","clicks","farmed","stunts","dowsed","brisks","skunks","linens","hammer","naiver","duster","elates","kooked","whacky","mather","loomed","soured","mosses","keeled","drains","drafty","cricks","glower","brayed","jester","mender","burros","arises","barker","father","creaks","prayed","bulges","heaped","called","volley","girted","forded","huffed","bergen","grated","douses","jagger","grovel","lashes","creeds","bonier","snacks","powder","curled","milker","posers","ribbed","tracts","stoked","russel","bummer","cusses","gouged","nailed","lobbed","novels","stands","caches","swanks","jutted","zinged","wigged","lunges","divers","cranny","pinter","guides","tigers","traces","berber","purges","hoaxer","either","bribed","camped","funked","creaky","noises","paused","splits","morrow","faults","ladies","dinged","smoker","calved","deters","kicker","wisher","ballad","filled","fobbed","tucker","steams","rubber","staled","chived","warred","draped","curfew","chafed","washer","tombed","basket","limned","rapped","swills","gashed","loaner","settee","layers","bootee","rioted","prance","sharps","wigner","ranted","hanker","leaden","groped","dalian","robbed","peeled","larder","spoofs","pushed","hallie","maiden","waller","pashas","grains","pinked","lodged","zipper","sneers","bootie","drives","former","deepen","carboy","snouts","fained","wilmer","trance","bugles","chimps","deeper","bolder","cupped","mauser","pagers","proven","teaser","plucky","curved","shoots","barged","mantes","reefer","coater","clotho","wanner","likens","swamis","troyes","breton","fences","pastas","quirky","boiler","canoes","looted","caries","stride","adorns","dwells","hatred","cloths","rotted","spooks","canyon","lances","denied","beefed","diaper","wiener","rifled","leader","ousted","sprays","ridged","mousey","darken","guiled","gasses","suited","drools","bloody","murals","lassie","babied","fitter","lessee","chiles","wrongs","malian","leaves","redder","funnel","broths","gushes","grants","doyens","simmer","locked","spoors","berger","landed","mosley","scorns","whiten","hurled","routed","careen","chorus","chasms","hopped","cadged","kicked","slewed","shrewd","mauled","saucer","jested","shriek","giblet","gnarls","foaled","roughs","copses","sacked","blends","slurps","cashew","grades","cramps","radius","tamped","truths","cleans","creams","manner","crimps","hauled","cheery","shells","asters","scalps","quotas","clears","clover","weeder","homers","pelted","hugged","marked","moaned","steely","jagged","glades","goshes","masked","ringer","eloped","vortex","gender","spotty","harken","hasten","smiths","mulled","specks","smiles","vainer","patted","harden","nicked","dooley","begged","belief","bushel","rivers","sealed","neuter","legged","garter","freaks","server","crimea","tossed","wilted","cheers","slides","cowley","snotty","willed","bowled","tortes","pranks","yelped","slaved","silver","swords","miners","fairer","trills","salted","copsed","crusts","hogged","seemed","revert","gusted","pixies","tamika","franks","crowed","rocked","fisher","sheers","pushes","drifts","scouts","sables","sallie","shiner","coupes","napped","drowse","traced","scenes","brakes","steele","beater","buries","turned","luther","bowers","lofted","blazer","serves","cagney","hansel","talker","warmed","flirts","braced","yukked","milken","forged","dodder","strafe","blurbs","snorts","jetted","picket","pistil","valved","pewter","crawls","strews","railed","clunks","smiled","dealer","cussed","hocked","spited","cowers","strobe","donned","brawls","minxes","philby","gavels","renter","losses","packet","defied","hazier","twines","balled","gaoled","esther","narrow","soused","crispy","souped","corned","cooley","rioter","talley","keaton","rocker","spades","billie","mattel","billet","horton","navels","sander","stoker","winded","wilder","cloyed","blazed","itched","docked","greene","boozed","ticket","temped","capons","bravos","rinded","brandi","massed","sobbed","shapes","yippee","script","lesion","mallet","seabed","medals","series","phases","grower","vertex","dented","tushed","barron","toffee","bushes","mouser","zenger","quaked","marley","surfed","harmed","mormon","flints","shamed","forgot","jailor","boater","sparer","shards","master","pistol","tooted","banned","drover","spices","gobbed","corals","chucks","kitten","whales","nickel","scrape","hosted","hences","morays","stomps","marcel","hummed","wonder","stoves","distil","coffer","quaker","curler","nurses","cabbed","jigger","grails","manges","larger","zipped","rovers","stints","nudges","marlin","exuded","storey","pester","longer","creeps","meaner","wallop","dewier","rivera","drones","valued","bugled","swards","cortes","charts","benson","wreaks","glares","levels","smithy","slater","suites","paired","fetter","rutted","levied","menses","wither","woolly","weeded","planed","censer","tested","pulled","hitter","slicer","tartar","chunky","whirrs","mewled","astern","walden","hilton","cached","geller","dolled","chores","sorter","soothe","reused","clumps","fueled","hurler","helled","packed","ripped","tanned","binder","flames","teased","punker","jerked","cannon","joists","whited","sagged","heaven","hansen","grayer","turfed","cranks","stater","bunted","horsey","shakes","brands","faints","barber","gorged","creamy","mowers","scrams","gashes","knacks","aeries","sticks","altars","hostel","pumped","reeves","litter","hoaxed","mushed","guided","ripper","bought","gelled","ranker","jennie","blares","saloon","bomber","mollie","scoops","coolie","hollis","shrunk","tattle","sensed","gasket","dodoes","mapped","strips","dodges","sailed","talked","sorted","lodges","livest","pastel","ladles","graded","thrice","thales","sagger","mellon","ganged","maroon","fluked","raised","nannie","dearer","lither","triked","dorset","clamps","lonnie","spates","larded","condor","sinker","narced","quaver","atones","farted","elopes","winger","mottle","loaned","smears","joanne","boozes","waster","digger","swoops","smokey","nation","drivel","ceased","miffed","faiths","pisses","frames","fooled","milled","dither","crazed","darryl","mulder","posses","sumter","weasel","pedals","brawny","charge","welted","spanks","sallow","joined","shaker","blocks","mattie","swirls","driver","belles","chomps","blower","roared","ratted","hailed","taunts","steamy","parrot","deafer","chewed","spaces","cuffed","molded","winked","runnel","hollow","fluted","bedded","crepes","stakes","vested","parley","burton","loiter","massey","carnap","closed","bailed","milder","heists","morale","putter","snyder","damion","conned","little","pooped","ticced","cocked","halves","wishes","francs","goblet","carlin","pecked","julius","raster","shocks","dawned","loosen","swears","buried","peters","treats","noshed","hedges","trumps","rabies","ronnie","forces","ticked","bodies","proved","dadoes","halved","warner","divest","thumbs","fettle","ponies","testis","ranked","clouts","slates","tauted","stools","dodged","chancy","trawls","things","sorrow","levies","glides","battle","sauced","doomed","seller","strove","ballet","bumper","gooses","foiled","plowed","glints","chanel","petals","darted","seared","trunks","hatter","yokels","vanned","tweedy","rubles","crones","nettie","roofed","dusted","dicker","fakers","rusted","bedder","darrin","bigger","baylor","crocks","niches","tented","cashed","splats","quoted","soloed","tessie","stiles","bearer","hissed","soiled","adored","bowery","snakes","wagers","rafter","crests","plaids","cordon","listed","lawson","scared","brazos","horded","greens","marred","mushes","hooper","halter","ration","calked","erodes","plumed","mummer","pinged","curios","slated","ranter","pillow","frills","whaled","bathos","madden","totted","reamed","bellow","golfer","seaman","barred","merger","hipped","silken","hastes","strays","slinks","hooted","convex","singed","leased","bummed","leaner","molted","naught","caters","tidied","forges","sealer","gulled","plumps","racket","fitted","rafted","drapes","nasser","tamara","winced","juliet","ledger","bettie","howell","reeved","spiced","thebes","apices","dorsey","welled","feeler","warded","reader","folded","lepers","cranky","bosses","ledges","player","yellow","lunged","mattes","confer","malign","shared","brandy","filmed","rhinos","pulsed","rouses","stones","mixers","cooped","joiner","papped","liston","capote","salvos","wicker","ciders","hoofed","wefted","locket","picker","nougat","limpid","hooter","jailer","peaces","mashes","custer","wallis","purees","trends","irater","honied","wavers","tanner","change","hinges","tatted","cookie","catnap","carton","crimed","betted","veined","surges","rumped","merlin","convey","placid","harped","dianna","hookey","nobles","carted","elided","whined","glover","bleats","stales","husker","hearer","tartan","weaker","skewer","lumbar","temper","gigged","gawked","mayors","pigged","gather","valves","mitten","largos","boreas","judges","cozens","censor","frilly","dumbed","downer","jogger","scolds","danced","floras","funded","lumped","dashes","azores","quites","chunks","washed","duller","bilges","cruels","brooks","fishes","smoked","leaped","hotter","trials","heaves","rouges","kissed","sleety","manses","spites","starts","banded","clings","titted","vetoed","mister","mildew","wailed","sheets","peeked","passer","felted","broken","lieges","ruffed","bracts","buster","muffed","lanker","breaks","coffey","sighed","charms","balded","kisser","booths","leaven","cheeps","billed","lauder","bumped","career","stocks","airier","limped","jeanie","roamed","carves","lilted","router","bonnie","denver","briggs","steeps","nerves","oinked","bucked","hooves","dancer","burris","parked","swells","collie","perked","cooler","fopped","wedder","malted","sabers","lidded","conner","rogues","fought","dapper","purled","crowds","barnes","bonner","globed","goners","yankee","probes","trains","sayers","jersey","valley","vatted","tauter","dulled","mucked","jotted","border","genres","banked","filter","hitler","dipper","dollie","sieves","joliet","tilted","checks","sports","soughs","ported","causes","gelded","mooter","grills","parred","tipped","placer","slayer","glided","basked","rinses","tamper","bunged","nabbed","climbs","faeces","hanson","brainy","wicket","crowns","calmed","tarred","spires","deanne","gravel","messes","snides","tugged","denier","moslem","erased","mutter","blahed","hunker","fasten","garbed","cracks","braked","rasped","ravens","mutton","tester","tories","pinker","titled","arisen","softer","woolen","disses","likest","dicier","nagged","lipton","plumbs","manged","faulty","sacred","whiter","erases","padres","haired","captor","metals","cardin","yowled","trusts","revels","boxers","toured","spouts","sodded","judged","holley","figged","pricey","lapses","harper","beaned","sewers","caused","willie","farmer","pissed","bevies","bolled","bugler","votive","person","linton","senses","supped","mashed","pincer","wetter","tangos","sticky","lodger","loader","daunts","peaked","moused","sleeps","lasted","tasked","awards","lovely","gushed","spurts","canter","mantis","coaled","groans","dannie","oopses","sneaky","vogues","mobile","plumes","chides","theses","marcia","parser","flexed","stayed","fouler","tusked","quartz","daubed","clancy","rouged","flaked","norton","dunner","corded","shelly","hester","fucker","polled","rodger","yeager","zinced","livens","browne","gonged","pubbed","sapped","thrive","placed","jensen","moises","scopes","stumpy","stocky","heller","levers","morals","wheres","gasped","jobber","leaved","champs","rosier","pallet","shooed","parses","bender","closet","pureed","routes","verges","bulled","foster","rummer","molten","condos","better","cotter","lassos","grafts","vendor","thrace","codded","tinker","bullet","beaker","garden","spiels","popper","skills","plated","farrow","flexes","esters","brains","handel","puller","dickey","creeks","ballot","singer","sicker","spayed","spoils","rubier","missed","framed","bonnet","molder","mugger","waived","taster","robles","tracks","nearer","lister","horsed","drakes","lopped","lubber","busied","button","eluded","ceases","sought","realer","lasers","pollen","crisps","binned","darrel","crafty","gleams","lonely","gordon","harley","damian","whiles","wilton","lesser","mallow","kenyon","wimped","scened","risked","hunter","rooter","ramses","inches","goaded","ferber","freaky","nerved","spoken","lovers","letter","marrow","bulbed","braver","sloped","breads","cannes","bassos","orated","clever","darren","bredes","gouger","servos","trites","troths","flunky","jammed","bugged","watter","motive","humped","writer","pestle","rilled","packer","foists","croats","floury","napier","floors","scotty","sevens","harrow","welter","quacks","daybed","lorded","pulses","pokier","fatten","midges","joints","snoopy","looter","monies","canted","riffed","misses","bunker","piston","yessed","earner","hawked","wedged","brewer","nested","graver","hoaxes","slaves","pricks","magpie","bernie","rapier","roster","poohed","corner","trysts","rogers","whirls","bathed","teasel","opener","minced","sister","dreamy","worker","rinked","panted","triton","mervin","snowed","leafed","thinks","lesson","millet","larson","lagged","likely","stormy","fortes","hordes","wovens","kinked","mettle","seated","shirts","solver","giants","jilted","leaded","mendez","lowers","bidder","greats","pepped","flours","versus","canton","weller","cowper","tapped","dueled","mussed","rubies","bonged","steals","formed","smalls","sculls","docket","ouster","gunned","thumps","curred","withes","putted","buttes","bloats","parsed","galley","preses","tagged","hanger","planes","chords","shafts","carson","posits","zinger","solves","tensed","tastes","rinsed","kenned","bitten","leslie","chanty","candor","daises","baggie","wedded","paints","moored","haloed","hornet","lifted","fender","guiles","swifts","flicks","lancer","spares","pellet","passed","finked","joanna","bidden","swamps","lapped","leered","served","shirrs","choker","limper","marker","nudged","triter","thanks","peered","bruins","loaves","fabled","lathes","pipers","hooped","orates","burned","swines","sprats","warder","colder","crazes","reined","prized","majors","darrow","waifed","rooked","rickey","patter","shrive","gropes","gassed","throve","region","weaken","hettie","walton","galled","convoy","wesson","exudes","tinted","clanks","blinks","slacks","stilts","franny","socket","wished","kidded","knotty","turves","cashes","geared","sunned","glowed","sadden","harlem","testes","sweets","becket","blazes","batter","fellow","clovis","copier","shaped","husked","gimlet","rooney","taints","sashes","bossed","cootie","franck","probed","bagged","smocks","batten","spared","chills","relics","meyers","grader","tromps","dimmer","pasted","pepper","capped","played","junket","easier","palmed","pander","vaguer","bulged","dissed","borges","raises","wallow","jigged","bogged","burped","neater","rammed","fibers","castor","skirts","cancer","tilled","spored","dander","denims","budges","trucks","sowers","yapped","cadges","wrists","hacker","graved","vipers","noshes","minted","lessor","cassia","wrecks","hidden","brando","honeys","chilli","ragged","breded","punier","stacey","sisses","jocked","croaks","dinned","walker","heston","flares","coined","cannot","chocks","leases","wander","balder","warmer","bawled","donnie","damson","header","chilly","models","simper","watery","milked","poises","combed","toilet","gallop","sonnet","loosed","yawned","splays","pauses","bother","graphs","shrews","scones","manuel","milers","hotels","bennie","flores","spells","grimed","tenses","staged","puffer","posies","motion","fudged","fainer","tatter","seraph","nansen","months","muppet","tamera","shaman","falser","becker","lisbon","clefts","weeper","mendel","girder","takers","torsos","forked","dances","stated","yelled","scants","frothy","rolled","yodels","listen","craned","brooms","suffer","easter","shills","craves","bleeps","belled","dished","bordon","zither","jacket","lammer","kirked","shaved","atoned","frumpy","nosier","vender","graced","clingy","chants","wrests","cursed","prunes","tarter","stripe","coffee","veiled","tweeds","shrine","spines","kegged","melvin","gasser","market","marten","peeped","sanger","somber","spider","netted","radium","slings","scarfs","mended","creels","shaves","payers","bunked","movers","beings","conked","cozies","benton","codger","prints","gusset","longed","burner","jambed","mullet","fogged","scores","carbon","sleeks","helped","waxier","gilded","harlot","winces","tenser","lowell","ramsey","kennan","booted","beaver","rested","shouts","hickey","looped","swings","wonted","dilled","defers","lolled","pupped","cruets","solved","romper","defter","chokes","kithed","garnet","bookie","stared","stares","latter","lazies","fanned","wagged","dunces","corked","cloned","prided","baxter","pusses","boomed","masses","warren","weaves","delves","handed","merton","lusher","hepper","gibber","sender","parsec","snares","masher","seamed","sweats","welles","gagged","curter","mother","beeped","vealed","shoved","slaver","hacked","gutted","ranged","bashed","closer","storks","meshed","cortex","copper","severn","gripes","carlos","scares","crates","boiled","ginned","mouses","raided","greyed","verier","slopes","fenced","sniper","priced","flawed","buffed","spacey","favors","platen","miller","walled","cutter","skated","holier","beamed","waiter","drowns","clomps","quarks","bested","frisks","purged","scalds","marian","flower","howled","plover","bikers","trails","hagged","smirks","sitter","carmen","lanced","plants","nobler","yakked","thesis","lassen","margin","wagner","sifter","houses","screws","booker","dormer","meters","padded","loaded","cartel","sutton","willis","chatty","dunked","dreamt","dalton","fables","coveys","muller","shanty","adders","tailor","helper","liters","butted","maiman","hollie","gallon","xavier","shrank","mickey","rather","powers","keened","doused","kisses","flanks","dotted","phased","dumped","linger","kramer","spaced","soften","strife","rowers","hovers","crimes","crooks","carrel","braces","lander","shrove","skulks","banker","itches","dropsy","misted","pulped","cloche","fawned","states","teared","beeper","raider","groves","livery","aerier","keenan","severe","sabres","bogies","coated","harlow","tanked","mellow","cozier","shanks","spooky","blamed","tricks","sleets","punted","jumped","caxton","warped","halley","frisky","shines","skater","lumber","truces","sliced","gibbet","narked","chives","graves","gummed","holler","glazes","nieves","hushed","nought","prated","chored","cloudy","kidder","huston","straws","twined","gifted","rodney","haloes","france","wirier","mercia","rubbed","coaxed","sumner","snipes","nipper","leiden","madman","margie","footed","firmed","budded","froths","senior","hoover","tailed","glider","straps","stalks","billow","racked","javier","zoomed","shades","whores","braids","roused","sudden","dogies","fencer","snaked","flings","traded","gunner","snider","staten","levees","lathed","sailor","waited","muster","clothe","lulled","cargos","revved","sooths","flamed","borers","feller","bladed","oliver","collin","wusses","murder","parted","jailed","frayed","doored","cheeks","misled","belted","winter","merges","shaven","fudges","tabbed","forget","sloths","cachet","mealed","sassed","salter","haunts","ranger","rivets","deeded","reaped","damped","crated","youths","whacks","tamers","misery","seeped","eerier","tiller","busses","gloved","hushes","cronus","pruned","casket","direst","guilds","motley","spools","fevers","snores","greece","elides","waists","rattle","trader","juster","rashes","stoney","pipped","solder","sinner","prides","rugged","steers","gnarly","titter","cities","walter","stolen","steaks","hawker","weaned","jobbed","jacked","pikers","hipper","spoilt","beeves","craved","gotten","balked","sherry","looney","crisis","callie","swiped","fished","rooted","bopped","bowler","escher","chumps","jerrod","lefter","snooty","fillet","scales","comets","lisped","decked","clowns","horned","robber","bottle","reeled","crapes","banter","martel","dowels","brandt","sweeps","heeled","tabled","manors","danger","dionne","prayer","decker","millie","boated","damned","horses","globes","failed","lammed","nigher","joyner","sobers","chided","tipper","parcel","flakes","fugger","elated","hinder","hopper","crafts","wipers","badder","jessie","matted","wafted","pealed","cheats","elites","torres","bushed","sneaks","tidies","brings","stalls","payees","zonked","danker","poshes","smelts","stoops","warden","chicks","ramsay","budged","firmer","glazed","heated","slices","hovels","belied","shifts","pauper","tinges","weston","casted","titles","droves","roomer","modals","seamen","wearer","blonde","berlin","libbed","tensor","hokier","lambed","graped","headed","copped","eroses","fagged","filler","keener","stages","civets","spills","tithed","sullen","sucked","briton","whaler","hooded","tittle","bucket","furled","darned","planet","clucks","batted","dagger","brides","severs","pathos","grainy","relied","carpel","makers","lancet","slowed","messed","ravels","faster","gabbed","chance","grayed","santos","spends","chinos","saints","swirly","dories","wilson","milton","clangs","manual","nodded","signer","stript","etched","vaster","wastes","stored","minces","purred","marvin","pinned","skulls","heaved","wadded","fowled","hashed","mullen","relief","hatted","primed","chaffs","canned","lackey","showed","shandy","chases","maggie","deafen","bussed","differ","worked","marted","ducked","socked","fussed","greyer","herder","trusty","follow","samson","babies","whorls","stanks","manson","cranes","murrow","shrink","genius","holder","lenses","yucked","termed","ruined","junker","belies","joshed","cooled","basted","greeks","fuller","healer","carver","havens","drunks","sucker","lotion","glared","healed","pocked","rifles","weaved","canoed","punter","hinton","settle","boobed","hinted","scored","harder","status","sloven","hayden","golfed","scoots","bloods","slaked","jugged","louses","cassie","shaded","rushed","pitied","barked","honked","rasher","forced","shaver","vowels","holden","pelvis","blades","chests","preyer","floods","deanna","cation","mapper","falter","dabbed","mocker","nestle","shucks","heeded","ticker","binges","summer","slumps","lusted","scampi","crofts","gorges","pardon","torses","smokes","lashed","bailey","jabbed","calmer","preset","forbes","hasted","wormed","winged","minors","banner","grazed","hewers","kernel","jolted","sniped","clunky","ratios","blinds","ganges","misers","spikes","riders","hallow","grumpy","barren","summed","infers","places","jarred","killer","plaint","goofed","subbed","prudes","sipped","kookie","whines","droopy","palled","cherry","proves","mobbed","spaded","cheese","pluses","bathes","motels","spewed","soaked","howler","puffed","malled","shrike","slided","fulled","pouted","shames","lessen","ringed","teemed","grands","linked","wooten","feuded","deaden","scents","flutes","salton"};
		Set<String> dict = new HashSet<String>();
		for(int i = 0;i < set.length;i++)
			dict.add(set[i]);
		System.out.println(t.findLadders(start, end, dict));
		
	}
	
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> rlst = new ArrayList<List<String>>();
        if(dict.contains(start))
            dict.remove(start);
        if(dict.contains(end))
            dict.remove(end);
        // Build the tree using BFS
        Map<String, Integer> layers = new HashMap<String, Integer>();
        List<List<String>> gross = new ArrayList<List<String>>();
        Queue<String> queue = new  LinkedList<String>();
        int minStep = dict.size()+2;
        List<String> firstlayer = new ArrayList<String>();
        firstlayer.add(start);
        gross.add(firstlayer);
        queue.add(start);
        layers.put(start,1);
        while(!queue.isEmpty()){
            String s = queue.poll();
            int layer = layers.get(s);
            for(int i = 0;i < s.length();i++){
                for(char c = 'a';c <= 'z';c++){
                    String t = s.substring(0,i)+c+s.substring(i+1,s.length());
                    if(t.equals(end)){
                        if(minStep > layer+1)
                            minStep = layer+1;
                    }
                    if(dict.contains(t) && layer+1 < minStep){
                    	if(gross.size() < layer+1){
                    		List<String> newLayer = new ArrayList<String>();
                    		newLayer.add(t);
                    		gross.add(newLayer);
                    	}else{
                    		gross.get(layer).add(t);
                    	}
                        dict.remove(t);
                        queue.add(t);
                        layers.put(t,layer+1);
                    }
                }
            }
        }
        
        // DFS on the tree to get path
        Deque<String> trace = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(start);
        while(!stack.isEmpty()){
            String s = stack.pop();
            int layer = layers.get(s);
            trace.add(s);
            boolean hasChild = false;
            if(isNeighbor(end,s)){
            	List<String> list = new ArrayList<String>();
                for(int j = 0;j < trace.size();j++){
                    String str = trace.pollFirst();
                    list.add(str);
                    trace.offerLast(str);
                }
                list.add(end);
                rlst.add(list);
            }
            if(layer < gross.size()){
            for(int i = 0;i < gross.get(layer).size();i++){
            	if(isNeighbor(gross.get(layer).get(i),s)){
            		stack.push(gross.get(layer).get(i));
            		hasChild = true;
            	}
            }
            }
            if(!hasChild){
                if(!stack.isEmpty()){
                    layer = layers.get(stack.peek());
                    while(!trace.isEmpty()){
//                        while(!layers.containsKey(trace.peekLast())){
//                            trace.pollLast();
//                        }
                        if(layers.get(trace.pollLast())==layer)
                            break;
                    }
                }
            }
        }
        
        return rlst;
        
    }
	
	private boolean isNeighbor(String a, String b){
		if(a.length()!=b.length()){return false;}
		int diff = 0;
		for(int i = 0;i < a.length();i++)
			diff += a.charAt(i)!=b.charAt(i)?1:0;
		return diff==1;
	}
	
//	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        List<List<String>> output = new ArrayList<List<String>>();
//        List<Integer> rlst = new ArrayList<Integer>();
//        List<List<String>> bfs = new ArrayList<List<String>>();
//        List<List<Integer>> path = new ArrayList<List<Integer>>();
//        int minStep = -1;
//        
//        // initialize
//        List<String> firstLayer = new ArrayList<String>();
//        firstLayer.add(start);
//        bfs.add(firstLayer);
//        List<Integer> rootPath = new ArrayList<Integer>();
//        rootPath.add(-1);
//        path.add(rootPath);
//        // BFS
//        while(minStep==-1 && bfs.get(bfs.size()-1).size()!=0){
//            List<String> newLayer = new ArrayList<String>();
//            List<Integer> newPath = new ArrayList<Integer>();
//            bfs.add(newLayer);
//            path.add(newPath);
//            for(int i = 0;i < bfs.get(bfs.size()-2).size();i++){
//                String s = bfs.get(bfs.size()-2).get(i);
//                if(dict.contains(s))
//                    dict.remove(s);
//            }
//            for(int i = 0;i < bfs.get(bfs.size()-2).size();i++){
//                String s = bfs.get(bfs.size()-2).get(i);
//                for(int j = 0;j < s.length();j++){
//                    for(char c = 'a';c <= 'z';c++){
//                        String t = s.substring(0,j)+c+s.substring(j+1,s.length());
//                        if(!t.equals(s)){
//                            if(t.equals(end)){
//                                if(minStep==-1)
//                                    minStep = bfs.size();
//                                if(minStep==bfs.size())
//                                    rlst.add(i);
//                            }
//                            if(dict.contains(t)){
//                                newPath.add(i);
//                                newLayer.add(t);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        // extract path from rlst
//        for(int i = 0;i < rlst.size();i++){
//            List<String> list = new ArrayList<String>();
//            Stack<String> stack = new Stack<String>();
//            stack.add(end);
//            int index = rlst.get(i);
//            for(int j = bfs.size()-2;j >= 0;j--){
//                stack.add(bfs.get(j).get(index));
//                index = path.get(j).get(index);
//            }
//            while(!stack.isEmpty()){
//                list.add(stack.pop());
//            }
//            output.add(list);
//        }
//        
//        return output;
//    }
	
	// O(n^2)
	static final double zero = 0.0001;
    public int maxPoints(Point[] points) {
    int max = 1;
    Map<Line, Set<Integer>> map = new HashMap<Line, Set<Integer>>();
    for(int i = 0; i < points.length-1;i++){
        for(int j = i+1; j < points.length;j++){
            if(points[i].x==points[j].x){
                Line line = new Line(points[i].x);
                if(!map.containsKey(line)){
                	Set<Integer> set = new HashSet<Integer>();
                	set.add(i);
                	set.add(j);
                    map.put(line, set);
                }else{
                	Set<Integer> set = map.get(line);
                	set.add(i);
                	set.add(j);
                	map.put(line, set);
                }
            }else{
                double k = (points[i].y - points[j].y)/(double)(points[i].x-points[j].x);
                double b = (double)points[i].y - k*points[i].x;
                Line line = new Line(k,b);
                if(!map.containsKey(line)){
                	Set<Integer> set = new HashSet<Integer>();
                	set.add(i);
                	set.add(j);
                	map.put(line, set);
                }else{
                	Set<Integer> set = map.get(line);
                	set.add(i);
                	set.add(j);
                	map.put(line, set);
                }
            }
        }
    }
    for(Map.Entry<Line, Set<Integer>> entry: map.entrySet())
        max = Math.max(max, entry.getValue().size());
    return points.length==0?0:max;
    }
	
	public ListNode mergeKLists(List<ListNode> lists) {
        for(int i = 1;i < lists.size();i *= 2)
            for(int j = 0;j+i < lists.size();j += 2*i)
                mergeTwoLists(lists.get(j),lists.get(j+i));
        return lists.size()==0?null:lists.get(0);
    }
    
    public void mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null)
            cur.next = l1;
        if(l2 != null)
            cur.next = l2;
        l1 = head.next;
    }
	
	public int jump(int[] A) {
        int step = 0;
        int low = 0;
        int high = 0;
        while(high < A.length-1){
        	int preLow = low;
            int preHigh = high;
            for(int t = preLow;t <= preHigh;t++)
                high = Math.max(t+A[t], high);
            low = preHigh+1;
            step++;
        }
        return step;
    }
	
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; left = null; right = null; }
	}
	
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> output = new ArrayList<TreeNode>();
        // edge case
        if(n==0){
            TreeNode zero = null;
            output.add(zero);
        }
        List<String> seq = generateSeq(n);
        for(int i = 0;i < seq.size();i++){
            String str = seq.get(i);
            if(str.length() > 3){
                if((int)(str.charAt(str.length()-2)-str.charAt(str.length()-1)) <= 2)
                    output.add(generateTree(str));
            }else{
                output.add(generateTree(str));
            }
        }
        return output;
    }
    
    private TreeNode generateTree(String s){
        TreeNode root = new TreeNode((int)(s.charAt(0)-'0'));;
        for(int i = 1;i < s.length();i++){
            TreeNode node = new TreeNode((int)(s.charAt(i)-'0'));
            addNodeOn(root, node);
        }
        return root;
    }
    
    private void addNodeOn(TreeNode root, TreeNode node){
        if(root==null){
            root = node;
        }else{
            if(node.val > root.val){
                if(root.right==null)
                    root.right = node;
                else
                    addNodeOn(root.right, node);
            }else{
                if(root.left==null)
                    root.left = node;
                else
                    addNodeOn(root.left, node);
            }
        }
    }
	
	public List<String> generateSeq(int n){
        List<String> list = new ArrayList<String>();
        // base case
        if(n==0){return list;}
        String oneStr = "1";
        list.add(oneStr);
        
        // general case
        for(int i = 2;i <= n;i++){
            int preLength = list.size();
            for(int j = 0;j < preLength;j++){
                String str = list.get(j);
                for(int t = 0;t <= str.length();t++){
                    String newStr = str.substring(0,t)+(char)(i+'0')+str.substring(t,str.length());
                    list.add(newStr);
                }
            }
            for(int j = 0;j < preLength;j++)
                list.remove(0);
        }
        
        return list;
    }
	
	class Node{
        int x;
        int y;
        char val;
        Node(int a,int b, char v){
            x = a;
            y = b;
            val = v;
        }
    }
    
    public boolean isValidSudoku(char[][] board) {
        Stack<Node> stack = new Stack<Node>();
        // make a copy of board
        char[][] origin = new char[9][9];
        Node last = new Node(0,0,'.');
        for(int i = 0;i < 9;i++)
            for(int j = 0;j < 9;j++)
                origin[i][j] = board[i][j];
        // find the first empty grid node
        boolean find = false;
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] == '.'){
                    for(char t = '1';t <= '9';t++){
                        if(isValid(board,i,j,t)){
                            Node node = new Node(i,j,t);
                            stack.push(node);
                        }
                    }
                    find = true;
                    break;
                }
            }
            if(find)
                break;
        }
     // find the last empty grid node
        find = false;
        for(int i = 8;i >=0;i--){
            for(int j = 8;j >= 0;j--){
                if(board[i][j] == '.'){
                    last = new Node(i,j,'.');
                    find = true;
                    break;
                }
            }
            if(find)
                break;
        }
                    
        // DFS
        while(!stack.isEmpty()){
            Node node = stack.pop();
            board[node.x][node.y] = node.val;
            if(node.x == last.x && node.y == last.y)
                return true;
            
            // find the next position
            boolean isFound = false;
            boolean hasNext = false;
            for(int j = node.y+1;j < 9;j++){ // find on current row
                if(board[node.x][j]=='.'){
                    isFound = true;
                    for(char t = '1';t <= '9';t++){
                        if(isValid(board,node.x,j,t)){
                            Node next = new Node(node.x,j,t);
                            stack.push(next);
                            hasNext = true;
                        }
                    }
                    break;
                }
            }
            if(!isFound){ // find on next rows
                for(int i = node.x+1;i < 9;i++){
                    for(int j = 0;j < 9;j++){
                        if(board[i][j]=='.'){
                            isFound = true;
                            for(char t = '1';t <= '9';t++){
                                if(isValid(board,i,j,t)){
                                    Node next = new Node(i,j,t);
                                    stack.push(next);
                                    hasNext = true;
                                }
                            } 
                            break;
                        }
                    }
                    if(isFound)
                        break;
                }
            }
            if(!isFound) // should never happen
                return false;
         // if no char can be filled, BACK TRACE
            if(!hasNext){
                if(stack.isEmpty()){
                    return false;
                }else{
                    Node peek = stack.peek();
                    if(peek.x==node.x){ // back trace current row
                        for(int j = node.y;j >= peek.y;j--)
                            board[node.x][j] = origin[node.x][j];
                    }else{ // back trace previous row
                        for(int j = node.y;j >= 0;j--)
                            board[node.x][j] = origin[node.x][j];
                        for(int i = node.x-1;i >= peek.x+1;i--)
                            for(int j = 8;j >= 0;j--)
                                board[i][j] = origin[i][j];
                        for(int j = 8;j >= peek.y;j--)
                            board[peek.x][j] = origin[peek.x][j];
                    }
                }
            }
            
        }
        return false;
    }
    private boolean isValid(char[][] board, int x, int y, char value){
        // its block
        int center_x = x/3 * 3 + 1;
        int center_y = y/3 * 3 + 1;
        for(int i = -1;i <= 1;i++)
            for(int j = -1;j <= 1;j++)
                if(board[center_x+i][center_y+i]==value)
                    return false;
        // its col and row
        for(int i = 0;i < 9;i++)
            if(board[i][y]==value)
                return false;
        for(int j = 0;j < 9;j++)
            if(board[x][j]==value)
                return false;
        return true;
    }
	
	public int removeDuplicates(int[] A) {
        int p1 = 0;
        int p2 = 0;
        int begin, end;
        if(A.length==0){return 0;}
        // points p2 to a next element;
        while(p2 < A.length){
            if(A[p1]!=A[p2])
                break;
            p2++;
        }
        end = p2;
        // set p1 to end
        begin = p1+1;
        while(begin < end && p2 < A.length){
            if(A[begin]==A[p1]){
                A[begin] = A[p2];
                // shift p2
                int temp = A[p2];
                while(p2 < A.length){
                    if(A[p2] != temp)
                        break;
                    p2++;
                }
            }else{
                p1 = begin;
            }
            begin++;
        }
        
        // set the rest according to p2
        while(p2 < A.length){
            A[begin++] = A[p2];
            int temp = A[p2];
            while(p2 < A.length){
                if(A[p2] != temp)
                    break;
                p2++;
            }
        }
        
        return begin;
    }
	
	public double findMedianSortedArrays(int A[], int B[]) {
        return findMedianSortedArrays(A,0,A.length-1,B,0,B.length-1);
    }
    
    private double findMedianSortedArrays(int A[], int A_begin, int A_end, int B[], int B_begin, int B_end){
        // base case
        int n = A_end-A_begin+1;
        int m = B_end-B_begin+1;
        
        if(n+m==0){return 0;}
        if(n==0){return findMedian(B,B_begin,B_end);}
        if(m==0){return findMedian(A,A_begin,A_end);}
        
        if(A[A_begin] >= B[B_end])
            return (findKthInArrays(B,B_begin,B_end,A,A_begin,A_end,(n+m)/2)+findKthInArrays(B,B_begin,B_end,A,A_begin,A_end,(n+m-1)/2))/2.0;
        if(A[A_end] <= B[B_begin])
            return (findKthInArrays(A,A_begin,A_end,B,B_begin,B_end,(n+m)/2)+findKthInArrays(A,A_begin,A_end,B,B_begin,B_end,(n+m-1)/2))/2.0;
            
        if(n==1){
            if(m%2!=0){
                if(A[A_begin] <= B[B_begin+(B_end-B_begin)/2-1])
                    return (B[B_begin+(B_end-B_begin)/2-1]+B[B_begin+(B_end-B_begin)/2])/2.0;
                else if(A[A_begin] >= B[B_begin+(B_end-B_begin)/2+1])
                    return (B[B_begin+(B_end-B_begin)/2+1]+B[B_begin+(B_end-B_begin)/2])/2.0;
                else
                    return (A[A_begin]+B[B_begin+(B_end-B_begin)/2])/2.0;
            }else{
                if(A[A_begin] <= B[B_begin+(B_end-B_begin)/2])
                    return B[B_begin+(B_end-B_begin)/2];
                else if(A[A_end] >= B[B_begin+(B_end-B_begin)/2+1])
                    return B[B_begin+(B_end-B_begin)/2+1];
                else
                    return A[A_begin];
            }
        }
        if(m==1){
            if(n%2!=0){
                if(B[B_begin] <= A[A_begin+(A_end-A_begin)/2-1])
                    return (A[A_begin+(A_end-A_begin)/2-1]+A[A_begin+(A_end-A_begin)/2])/2.0;
                else if(B[B_begin] >= A[A_begin+(A_end-A_begin)/2+1])
                    return (A[A_begin+(A_end-A_begin)/2+1]+A[A_begin+(A_end-A_begin)/2])/2.0;
                else
                    return (B[B_begin]+A[A_begin+(A_end-A_begin)/2])/2.0;
            }else{
                if(B[B_begin] <= A[A_begin+(A_end-A_begin)/2])
                    return A[A_begin+(A_end-A_begin)/2];
                else if(B[B_end] >= A[A_begin+(A_end-A_begin)/2+1])
                    return A[A_begin+(A_end-A_begin)/2+1];
                else
                    return B[B_begin];
            }
        }
        
        // general case
        double A_median = findMedian(A,A_begin,A_end);
        double B_median = findMedian(B,B_begin,B_end);
        if(A_median==B_median){return A_median;}
        int cut = Math.min((A_end-A_begin+1)/2,(B_end-B_begin+1)/2);
        int A_left = A[A_begin+(A_end-A_begin-1)/2];
        int A_right = A[A_begin+(A_end-A_begin)/2+1];
        int B_left = B[B_begin+(B_end-B_begin-1)/2];
        int B_right = B[B_begin+(B_end-B_begin)/2+1];
        if(A_left > B_left)
            B_begin += cut;
        else
            A_begin += cut;
        if(A_right > B_right)
            A_end -= cut;
        else
            B_end -= cut;
        return findMedianSortedArrays(A,A_begin,A_end,B,B_begin,B_end);
    }
    
    private double findMedian(int A[], int begin, int end){
        if((end-begin+1)%2==0)
            return (A[begin + (end-begin)/2]+A[begin+(end-begin)/2+1])/2.0;
        else
            return A[begin + (end-begin)/2];
    }
    
    private double findKthInArrays(int A[], int A_begin, int A_end, int B[], int B_begin, int B_end, int k){
        if(k >= A_end-A_begin+1)
            return B[B_begin+k-(A_end-A_begin+1)];
        else
            return A[A_begin+k];
    }
}
