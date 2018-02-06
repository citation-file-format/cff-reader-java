/**
 * Copyright (c) 2018ff. Stephan Druskat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.research_software.citation.cff.model.objects;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Provides constants for static values for different model keys.
 * 
 * For an overview of the defined values, cf. the format specifications
 * at <https://citation-file-format.github.io/>.
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
final class DefinedValues {

	/**
	 * Valid values for **reference `type`s** according to the
	 * [format specifications](https://citation-file-format.github.io/).
	 */
	public final static Set<String> REFERENCE_TYPES = new HashSet<>(Arrays.asList("art", "article", "audiovisual",
			"bill", "blog", "book", "catalogue", "conference", "conference-paper", "data", "database", "dictionary",
			"edited-work", "encyclopedia", "film-broadcast", "generic", "government-document", "grant", "hearing",
			"historical-work", "legal-case", "legal-rule", "magazine-article", "manual", "map", "multimedia", "music",
			"newspaper-article", "pamphlet", "patent", "personal-communication", "proceedings", "report", "serial",
			"slides", "software", "software-code", "software-container", "software-executable",
			"software-virtual-machine", "sound-recording", "standard", "statute", "thesis", "unpublished", "video",
			"website"));

	/**
	 * Valid values for **reference `status`** according to the
	 * [format specifications](https://citation-file-format.github.io/).
	 */
	public static final Set<String> REFERENCE_STATUS = new HashSet<>(
			Arrays.asList("in-preparation", "abstract", "submitted", "in-press", "advance-online", "preprint"));

	/**
	 * A regex for valid ORCID iDs.
	 * 
	 * Cf. <https://support.orcid.org/knowledgebase/articles/116780-structure-of-the-orcid-identifier>,
	 * section "Expressing the ORCID iD".
	 */
	public static final String ORCID_URL_PATTERN = "https://orcid\\.org/\\d{4}-\\d{4}-\\d{4}-\\d{4}";

	/**
	 * Valid values for **`country`** according to the
	 * [format specifications](https://citation-file-format.github.io/).
	 * 
	 * These are ISO 3166-1 alpha-2 codes.
	 */
	public static final Set<String> COUNTRY = new HashSet<>(Arrays.asList("AF", "AX", "AL", "DZ", "AS", "AD", "AO",
			"AI", "AQ", "AG", "AR", "AM", "AW", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BY", "BE", "BZ", "BJ", "BM",
			"BT", "BO", "BQ", "BA", "BW", "BV", "BR", "IO", "BN", "BG", "BF", "BI", "CV", "KH", "CM", "CA", "KY", "CF",
			"TD", "CL", "CN", "CX", "CC", "CO", "KM", "CG", "CD", "CK", "CR", "CI", "HR", "CU", "CW", "CY", "CZ", "DK",
			"DJ", "DM", "DO", "EC", "EG", "SV", "GQ", "ER", "EE", "ET", "FK", "FO", "FJ", "FI", "FR", "GF", "PF", "TF",
			"GA", "GM", "GE", "DE", "GH", "GI", "GR", "GL", "GD", "GP", "GU", "GT", "GG", "GN", "GW", "GY", "HT", "HM",
			"VA", "HN", "HK", "HU", "IS", "IN", "ID", "IR", "IQ", "IE", "IM", "IL", "IT", "JM", "JP", "JE", "JO", "KZ",
			"KE", "KI", "KP", "KR", "KW", "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI", "LT", "LU", "MO", "MK", "MG",
			"MW", "MY", "MV", "ML", "MT", "MH", "MQ", "MR", "MU", "YT", "MX", "FM", "MD", "MC", "MN", "ME", "MS", "MA",
			"MZ", "MM", "NA", "NR", "NP", "NL", "NC", "NZ", "NI", "NE", "NG", "NU", "NF", "MP", "NO", "OM", "PK", "PW",
			"PS", "PA", "PG", "PY", "PE", "PH", "PN", "PL", "PT", "PR", "QA", "RE", "RO", "RU", "RW", "BL", "SH", "KN",
			"LC", "MF", "PM", "VC", "WS", "SM", "ST", "SA", "SN", "RS", "SC", "SL", "SG", "SX", "SK", "SI", "SB", "SO",
			"ZA", "GS", "SS", "ES", "LK", "SD", "SR", "SJ", "SZ", "SE", "CH", "SY", "TW", "TJ", "TZ", "TH", "TL", "TG",
			"TK", "TO", "TT", "TN", "TR", "TM", "TC", "TV", "UG", "UA", "AE", "GB", "UM", "US", "UY", "UZ", "VU", "VE",
			"VN", "VG", "VI", "WF", "EH", "YE", "ZM", "ZW"));

	/**
	 * Validates whether a value for **`language`** is valid,
	 * i.e., is a 3-char ISO 639-3 or 2-char ISO 639-1 code.
	 * 
	 * @param language The language string to check for validity.
	 * @return Whether the language string is valid.
	 */
	@SuppressWarnings("unchecked")
	public static boolean isLanguageValid(String language) {
		// Use reflection to get the correct Set
		Set<String> languageField = null;
		try {
			Field field = DefinedValues.class.getField("LANGUAGES_" + language.substring(0, 1).toUpperCase());
			if (field != null) {
				languageField = (Set<String>) field.get(null);
				return languageField.contains(language);
			}
		}
		catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			return false;
		}
		return false;
	}

	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_A = new HashSet<>(Arrays.asList("aa", "aaa", "aab", "aac", "aad", "aae",
			"aaf", "aag", "aah", "aai", "aak", "aal", "aan", "aao", "aap", "aaq", "aar", "aas", "aat", "aau", "aaw",
			"aax", "aaz", "ab", "aba", "abb", "abc", "abd", "abe", "abf", "abg", "abh", "abi", "abj", "abk", "abl",
			"abm", "abn", "abo", "abp", "abq", "abr", "abs", "abt", "abu", "abv", "abw", "abx", "aby", "abz", "aca",
			"acb", "acd", "ace", "acf", "ach", "aci", "ack", "acl", "acm", "acn", "acp", "acq", "acr", "acs", "act",
			"acu", "acv", "acw", "acx", "acy", "acz", "ada", "adb", "add", "ade", "adf", "adg", "adh", "adi", "adj",
			"adl", "adn", "ado", "adq", "adr", "ads", "adt", "adu", "adw", "adx", "ady", "adz", "ae", "aea", "aeb",
			"aec", "aed", "aee", "aek", "ael", "aem", "aen", "aeq", "aer", "aes", "aeu", "aew", "aey", "aez", "af",
			"afb", "afd", "afe", "afg", "afh", "afi", "afk", "afn", "afo", "afp", "afr", "afs", "aft", "afu", "afz",
			"aga", "agb", "agc", "agd", "age", "agf", "agg", "agh", "agi", "agj", "agk", "agl", "agm", "agn", "ago",
			"agq", "agr", "ags", "agt", "agu", "agv", "agw", "agx", "agy", "agz", "aha", "ahb", "ahg", "ahh", "ahi",
			"ahk", "ahl", "ahm", "ahn", "aho", "ahp", "ahr", "ahs", "aht", "aia", "aib", "aic", "aid", "aie", "aif",
			"aig", "aih", "aii", "aij", "aik", "ail", "aim", "ain", "aio", "aip", "aiq", "air", "ais", "ait", "aiw",
			"aix", "aiy", "aja", "ajg", "aji", "ajn", "ajp", "ajt", "aju", "ajw", "ajz", "ak", "aka", "akb", "akc",
			"akd", "ake", "akf", "akg", "akh", "aki", "akj", "akk", "akl", "akm", "ako", "akp", "akq", "akr", "aks",
			"akt", "aku", "akv", "akw", "akx", "aky", "akz", "ala", "alc", "ald", "ale", "alf", "alh", "ali", "alj",
			"alk", "all", "alm", "aln", "alo", "alp", "alq", "alr", "als", "alt", "alu", "alw", "alx", "aly", "alz",
			"am", "ama", "amb", "amc", "ame", "amf", "amg", "amh", "ami", "amj", "amk", "aml", "amm", "amn", "amo",
			"amp", "amq", "amr", "ams", "amt", "amu", "amv", "amw", "amx", "amy", "amz", "an", "ana", "anb", "anc",
			"and", "ane", "anf", "ang", "anh", "ani", "anj", "ank", "anl", "anm", "ann", "ano", "anp", "anq", "anr",
			"ans", "ant", "anu", "anv", "anw", "anx", "any", "anz", "aoa", "aob", "aoc", "aod", "aoe", "aof", "aog",
			"aoh", "aoi", "aoj", "aok", "aol", "aom", "aon", "aor", "aos", "aot", "aou", "aox", "aoz", "apb", "apc",
			"apd", "ape", "apf", "apg", "aph", "api", "apj", "apk", "apl", "apm", "apn", "apo", "app", "apq", "apr",
			"aps", "apt", "apu", "apv", "apw", "apx", "apy", "apz", "aqc", "aqd", "aqg", "aqm", "aqn", "aqp", "aqr",
			"aqt", "aqz", "ar", "ara", "arb", "arc", "ard", "are", "arg", "arh", "ari", "arj", "ark", "arl", "arn",
			"aro", "arp", "arq", "arr", "ars", "aru", "arv", "arw", "arx", "ary", "arz", "as", "asa", "asb", "asc",
			"asd", "ase", "asf", "asg", "ash", "asi", "asj", "ask", "asl", "asm", "asn", "aso", "asp", "asq", "asr",
			"ass", "ast", "asu", "asv", "asw", "asx", "asy", "asz", "ata", "atb", "atc", "atd", "ate", "atg", "ati",
			"atj", "atk", "atl", "atm", "atn", "ato", "atp", "atq", "atr", "ats", "att", "atu", "atv", "atw", "atx",
			"aty", "atz", "aua", "aub", "auc", "aud", "aug", "auh", "aui", "auj", "auk", "aul", "aum", "aun", "auo",
			"aup", "auq", "aur", "aut", "auu", "auw", "aux", "auy", "auz", "av", "ava", "avb", "avd", "ave", "avi",
			"avk", "avl", "avm", "avn", "avo", "avs", "avt", "avu", "avv", "awa", "awb", "awc", "awe", "awg", "awh",
			"awi", "awk", "awm", "awn", "awo", "awr", "aws", "awt", "awu", "awv", "aww", "awx", "awy", "axb", "axe",
			"axg", "axk", "axl", "axm", "axx", "ay", "aya", "ayb", "ayc", "ayd", "aye", "ayg", "ayh", "ayi", "ayk",
			"ayl", "aym", "ayn", "ayo", "ayp", "ayq", "ayr", "ays", "ayt", "ayu", "ayy", "ayz", "az", "aza", "azb",
			"azd", "aze", "azg", "azj", "azm", "azn", "azo", "azt", "azz"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_B = new HashSet<>(Arrays.asList("ba", "baa", "bab", "bac", "bae", "baf",
			"bag", "bah", "baj", "bak", "bal", "bam", "ban", "bao", "bap", "bar", "bas", "bau", "bav", "baw", "bax",
			"bay", "bba", "bbb", "bbc", "bbd", "bbe", "bbf", "bbg", "bbh", "bbi", "bbj", "bbk", "bbl", "bbm", "bbn",
			"bbo", "bbp", "bbq", "bbr", "bbs", "bbt", "bbu", "bbv", "bbw", "bbx", "bby", "bbz", "bca", "bcb", "bcc",
			"bcd", "bce", "bcf", "bcg", "bch", "bci", "bcj", "bck", "bcl", "bcm", "bcn", "bco", "bcp", "bcq", "bcr",
			"bcs", "bct", "bcu", "bcv", "bcw", "bcy", "bcz", "bda", "bdb", "bdc", "bdd", "bde", "bdf", "bdg", "bdh",
			"bdi", "bdj", "bdk", "bdl", "bdm", "bdn", "bdo", "bdp", "bdq", "bdr", "bds", "bdt", "bdu", "bdv", "bdw",
			"bdx", "bdy", "bdz", "be", "bea", "beb", "bec", "bed", "bee", "bef", "beg", "beh", "bei", "bej", "bek",
			"bel", "bem", "ben", "beo", "bep", "beq", "bes", "bet", "beu", "bev", "bew", "bex", "bey", "bez", "bfa",
			"bfb", "bfc", "bfd", "bfe", "bff", "bfg", "bfh", "bfi", "bfj", "bfk", "bfl", "bfm", "bfn", "bfo", "bfp",
			"bfq", "bfr", "bfs", "bft", "bfu", "bfw", "bfx", "bfy", "bfz", "bg", "bga", "bgb", "bgc", "bgd", "bge",
			"bgf", "bgg", "bgi", "bgj", "bgk", "bgl", "bgn", "bgo", "bgp", "bgq", "bgr", "bgs", "bgt", "bgu", "bgv",
			"bgw", "bgx", "bgy", "bgz", "bh", "bha", "bhb", "bhc", "bhd", "bhe", "bhf", "bhg", "bhh", "bhi", "bhj",
			"bhl", "bhm", "bhn", "bho", "bhp", "bhq", "bhr", "bhs", "bht", "bhu", "bhv", "bhw", "bhx", "bhy", "bhz",
			"bi", "bia", "bib", "bic", "bid", "bie", "bif", "big", "bij", "bik", "bil", "bim", "bin", "bio", "bip",
			"biq", "bir", "bis", "bit", "biu", "biv", "biw", "bix", "biy", "biz", "bja", "bjb", "bjc", "bje", "bjf",
			"bjg", "bjh", "bji", "bjj", "bjk", "bjl", "bjm", "bjn", "bjo", "bjp", "bjr", "bjs", "bjt", "bju", "bjv",
			"bjw", "bjx", "bjy", "bjz", "bka", "bkc", "bkd", "bkf", "bkg", "bkh", "bki", "bkj", "bkk", "bkl", "bkm",
			"bkn", "bko", "bkp", "bkq", "bkr", "bks", "bkt", "bku", "bkv", "bkw", "bkx", "bky", "bkz", "bla", "blb",
			"blc", "bld", "ble", "blf", "blg", "blh", "bli", "blj", "blk", "bll", "blm", "bln", "blo", "blp", "blq",
			"blr", "bls", "blt", "blv", "blw", "blx", "bly", "blz", "bm", "bma", "bmb", "bmc", "bmd", "bme", "bmf",
			"bmg", "bmh", "bmi", "bmj", "bmk", "bml", "bmm", "bmn", "bmo", "bmp", "bmq", "bmr", "bms", "bmt", "bmu",
			"bmv", "bmw", "bmx", "bmz", "bn", "bna", "bnb", "bnc", "bnd", "bne", "bnf", "bng", "bni", "bnj", "bnk",
			"bnl", "bnm", "bnn", "bno", "bnp", "bnq", "bnr", "bns", "bnu", "bnv", "bnw", "bnx", "bny", "bnz", "bo",
			"boa", "bob", "bod", "boe", "bof", "bog", "boh", "boi", "boj", "bok", "bol", "bom", "bon", "boo", "bop",
			"boq", "bor", "bos", "bot", "bou", "bov", "bow", "box", "boy", "boz", "bpa", "bpb", "bpd", "bpg", "bph",
			"bpi", "bpj", "bpk", "bpl", "bpm", "bpn", "bpo", "bpp", "bpq", "bpr", "bps", "bpt", "bpu", "bpv", "bpw",
			"bpx", "bpy", "bpz", "bqa", "bqb", "bqc", "bqd", "bqf", "bqg", "bqh", "bqi", "bqj", "bqk", "bql", "bqm",
			"bqn", "bqo", "bqp", "bqq", "bqr", "bqs", "bqt", "bqu", "bqv", "bqw", "bqx", "bqy", "bqz", "br", "bra",
			"brb", "brc", "brd", "bre", "brf", "brg", "brh", "bri", "brj", "brk", "brl", "brm", "brn", "bro", "brp",
			"brq", "brr", "brs", "brt", "bru", "brv", "brw", "brx", "bry", "brz", "bs", "bsa", "bsb", "bsc", "bse",
			"bsf", "bsg", "bsh", "bsi", "bsj", "bsk", "bsl", "bsm", "bsn", "bso", "bsp", "bsq", "bsr", "bss", "bst",
			"bsu", "bsv", "bsw", "bsx", "bsy", "bta", "btc", "btd", "bte", "btf", "btg", "bth", "bti", "btj", "btm",
			"btn", "bto", "btp", "btq", "btr", "bts", "btt", "btu", "btv", "btw", "btx", "bty", "btz", "bua", "bub",
			"buc", "bud", "bue", "buf", "bug", "buh", "bui", "buj", "buk", "bul", "bum", "bun", "buo", "bup", "buq",
			"bus", "but", "buu", "buv", "buw", "bux", "buy", "buz", "bva", "bvb", "bvc", "bvd", "bve", "bvf", "bvg",
			"bvh", "bvi", "bvj", "bvk", "bvl", "bvm", "bvn", "bvo", "bvp", "bvq", "bvr", "bvt", "bvu", "bvv", "bvw",
			"bvx", "bvy", "bvz", "bwa", "bwb", "bwc", "bwd", "bwe", "bwf", "bwg", "bwh", "bwi", "bwj", "bwk", "bwl",
			"bwm", "bwn", "bwo", "bwp", "bwq", "bwr", "bws", "bwt", "bwu", "bww", "bwx", "bwy", "bwz", "bxa", "bxb",
			"bxc", "bxd", "bxe", "bxf", "bxg", "bxh", "bxi", "bxj", "bxk", "bxl", "bxm", "bxn", "bxo", "bxp", "bxq",
			"bxr", "bxs", "bxu", "bxv", "bxw", "bxz", "bya", "byb", "byc", "byd", "bye", "byf", "byg", "byh", "byi",
			"byj", "byk", "byl", "bym", "byn", "byo", "byp", "byq", "byr", "bys", "byt", "byv", "byw", "byx", "byz",
			"bza", "bzb", "bzc", "bzd", "bze", "bzf", "bzg", "bzh", "bzi", "bzj", "bzk", "bzl", "bzm", "bzn", "bzo",
			"bzp", "bzq", "bzr", "bzs", "bzt", "bzu", "bzv", "bzw", "bzx", "bzy", "bzz"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_C = new HashSet<>(Arrays.asList("ca", "caa", "cab", "cac", "cad", "cae",
			"caf", "cag", "cah", "caj", "cak", "cal", "cam", "can", "cao", "cap", "caq", "car", "cas", "cat", "cav",
			"caw", "cax", "cay", "caz", "cbb", "cbc", "cbd", "cbg", "cbi", "cbj", "cbk", "cbl", "cbn", "cbo", "cbq",
			"cbr", "cbs", "cbt", "cbu", "cbv", "cbw", "cby", "cca", "ccc", "ccd", "cce", "ccg", "cch", "ccj", "ccl",
			"ccm", "cco", "ccp", "ccr", "cda", "cde", "cdf", "cdg", "cdh", "cdi", "cdj", "cdm", "cdn", "cdo", "cdr",
			"cds", "cdy", "cdz", "ce", "cea", "ceb", "ceg", "cek", "cen", "ces", "cet", "cfa", "cfd", "cfg", "cfm",
			"cga", "cgc", "cgg", "cgk", "ch", "cha", "chb", "chc", "chd", "che", "chf", "chg", "chh", "chj", "chk",
			"chl", "chm", "chn", "cho", "chp", "chq", "chr", "cht", "chu", "chv", "chw", "chx", "chy", "chz", "cia",
			"cib", "cic", "cid", "cie", "cih", "cik", "cim", "cin", "cip", "cir", "ciw", "ciy", "cja", "cje", "cjh",
			"cji", "cjk", "cjm", "cjn", "cjo", "cjp", "cjs", "cjv", "cjy", "ckb", "ckh", "ckl", "ckn", "cko", "ckq",
			"ckr", "cks", "ckt", "cku", "ckv", "ckx", "cky", "ckz", "cla", "clc", "cld", "cle", "clh", "cli", "clj",
			"clk", "cll", "clm", "clo", "clt", "clu", "clw", "cly", "cma", "cme", "cmg", "cmi", "cml", "cmm", "cmn",
			"cmo", "cmr", "cms", "cmt", "cna", "cnb", "cnc", "cng", "cnh", "cni", "cnk", "cnl", "cno", "cns", "cnt",
			"cnu", "cnw", "cnx", "co", "coa", "cob", "coc", "cod", "coe", "cof", "cog", "coh", "coj", "cok", "col",
			"com", "con", "coo", "cop", "coq", "cor", "cos", "cot", "cou", "cov", "cow", "cox", "coz", "cpa", "cpb",
			"cpc", "cpg", "cpi", "cpn", "cpo", "cps", "cpu", "cpx", "cpy", "cqd", "cr", "cra", "crb", "crc", "crd",
			"cre", "crf", "crg", "crh", "cri", "crj", "crk", "crl", "crm", "crn", "cro", "crq", "crr", "crs", "crt",
			"crv", "crw", "crx", "cry", "crz", "cs", "csa", "csb", "csc", "csd", "cse", "csf", "csg", "csh", "csi",
			"csj", "csk", "csl", "csm", "csn", "cso", "csq", "csr", "css", "cst", "csv", "csw", "csy", "csz", "cta",
			"ctc", "ctd", "cte", "ctg", "cth", "ctl", "ctm", "ctn", "cto", "ctp", "cts", "ctt", "ctu", "ctz", "cu",
			"cua", "cub", "cuc", "cug", "cuh", "cui", "cuj", "cuk", "cul", "cuo", "cup", "cuq", "cur", "cut", "cuu",
			"cuv", "cuw", "cux", "cv", "cvg", "cvn", "cwa", "cwb", "cwd", "cwe", "cwg", "cwt", "cy", "cya", "cyb",
			"cym", "cyo", "czh", "czk", "czn", "czo", "czt"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_D = new HashSet<>(Arrays.asList("da", "daa", "dac", "dad", "dae", "dag",
			"dah", "dai", "daj", "dak", "dal", "dam", "dan", "dao", "daq", "dar", "das", "dau", "dav", "daw", "dax",
			"daz", "dba", "dbb", "dbd", "dbe", "dbf", "dbg", "dbi", "dbj", "dbl", "dbm", "dbn", "dbo", "dbp", "dbq",
			"dbr", "dbt", "dbu", "dbv", "dbw", "dby", "dcc", "dcr", "dda", "ddd", "dde", "ddg", "ddi", "ddj", "ddn",
			"ddo", "ddr", "dds", "ddw", "de", "dec", "ded", "dee", "def", "deg", "deh", "dei", "dek", "del", "dem",
			"den", "dep", "deq", "der", "des", "deu", "dev", "dez", "dga", "dgb", "dgc", "dgd", "dge", "dgg", "dgh",
			"dgi", "dgk", "dgl", "dgn", "dgo", "dgr", "dgs", "dgt", "dgu", "dgw", "dgx", "dgz", "dhd", "dhg", "dhi",
			"dhl", "dhm", "dhn", "dho", "dhr", "dhs", "dhu", "dhv", "dhw", "dhx", "dia", "dib", "dic", "did", "dif",
			"dig", "dih", "dii", "dij", "dik", "dil", "dim", "din", "dio", "dip", "diq", "dir", "dis", "dit", "diu",
			"div", "diw", "dix", "diy", "diz", "dja", "djb", "djc", "djd", "dje", "djf", "dji", "djj", "djk", "djm",
			"djn", "djo", "djr", "dju", "djw", "dka", "dkk", "dkr", "dks", "dkx", "dlg", "dlk", "dlm", "dln", "dma",
			"dmb", "dmc", "dmd", "dme", "dmg", "dmk", "dml", "dmm", "dmo", "dmr", "dms", "dmu", "dmv", "dmw", "dmx",
			"dmy", "dna", "dnd", "dne", "dng", "dni", "dnj", "dnk", "dnn", "dnr", "dnt", "dnu", "dnv", "dnw", "dny",
			"doa", "dob", "doc", "doe", "dof", "doh", "doi", "dok", "dol", "don", "doo", "dop", "doq", "dor", "dos",
			"dot", "dov", "dow", "dox", "doy", "doz", "dpp", "drb", "drc", "drd", "dre", "drg", "dri", "drl", "drn",
			"dro", "drq", "drr", "drs", "drt", "dru", "dry", "dsb", "dse", "dsh", "dsi", "dsl", "dsn", "dso", "dsq",
			"dta", "dtb", "dtd", "dth", "dti", "dtk", "dtm", "dtn", "dto", "dtp", "dtr", "dts", "dtt", "dtu", "dty",
			"dua", "dub", "duc", "dud", "due", "duf", "dug", "duh", "dui", "duk", "dul", "dum", "dun", "duo", "dup",
			"duq", "dur", "dus", "duu", "duv", "duw", "dux", "duy", "duz", "dv", "dva", "dwa", "dwr", "dws", "dwu",
			"dww", "dwy", "dya", "dyb", "dyd", "dyg", "dyi", "dym", "dyn", "dyo", "dyu", "dyy", "dz", "dza", "dze",
			"dzg", "dzl", "dzn", "dzo"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_E = new HashSet<>(Arrays.asList("eaa", "ebg", "ebk", "ebo", "ebr", "ebu",
			"ecr", "ecs", "ecy", "ee", "eee", "efa", "efe", "efi", "ega", "egl", "ego", "egy", "ehu", "eip", "eit",
			"eiv", "eja", "eka", "ekc", "eke", "ekg", "eki", "ekk", "ekl", "ekm", "eko", "ekp", "ekr", "eky", "el",
			"ele", "elh", "eli", "elk", "ell", "elm", "elo", "elu", "elx", "ema", "emb", "eme", "emg", "emi", "emk",
			"emm", "emn", "emp", "ems", "emu", "emw", "emx", "emy", "en", "ena", "enb", "enc", "end", "enf", "eng",
			"enh", "enl", "enm", "enn", "eno", "enq", "enr", "enu", "env", "enw", "enx", "eo", "eot", "epi", "epo",
			"era", "erg", "erh", "eri", "erk", "ero", "err", "ers", "ert", "erw", "es", "ese", "esg", "esh", "esi",
			"esk", "esl", "esm", "esn", "eso", "esq", "ess", "est", "esu", "esy", "et", "etb", "etc", "eth", "etn",
			"eto", "etr", "ets", "ett", "etu", "etx", "etz", "eu", "eus", "eve", "evh", "evn", "ewe", "ewo", "ext",
			"eya", "eyo", "eza", "eze"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_F = new HashSet<>(Arrays.asList("fa", "faa", "fab", "fad", "faf", "fag",
			"fah", "fai", "faj", "fak", "fal", "fam", "fan", "fao", "fap", "far", "fas", "fat", "fau", "fax", "fay",
			"faz", "fbl", "fcs", "fer", "ff", "ffi", "ffm", "fgr", "fi", "fia", "fie", "fij", "fil", "fin", "fip",
			"fir", "fit", "fiw", "fj", "fkk", "fkv", "fla", "flh", "fli", "fll", "fln", "flr", "fly", "fmp", "fmu",
			"fnb", "fng", "fni", "fo", "fod", "foi", "fom", "fon", "for", "fos", "fpe", "fqs", "fr", "fra", "frc",
			"frd", "frk", "frm", "fro", "frp", "frq", "frr", "frs", "frt", "fry", "fse", "fsl", "fss", "fub", "fuc",
			"fud", "fue", "fuf", "fuh", "fui", "fuj", "ful", "fum", "fun", "fuq", "fur", "fut", "fuu", "fuv", "fuy",
			"fvr", "fwa", "fwe", "fy"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_G = new HashSet<>(Arrays.asList("ga", "gaa", "gab", "gac", "gad", "gae",
			"gaf", "gag", "gah", "gai", "gaj", "gak", "gal", "gam", "gan", "gao", "gap", "gaq", "gar", "gas", "gat",
			"gau", "gaw", "gax", "gay", "gaz", "gba", "gbb", "gbd", "gbe", "gbf", "gbg", "gbh", "gbi", "gbj", "gbk",
			"gbl", "gbm", "gbn", "gbo", "gbp", "gbq", "gbr", "gbs", "gbu", "gbv", "gbw", "gbx", "gby", "gbz", "gcc",
			"gcd", "gce", "gcf", "gcl", "gcn", "gcr", "gct", "gd", "gda", "gdb", "gdc", "gdd", "gde", "gdf", "gdg",
			"gdh", "gdi", "gdj", "gdk", "gdl", "gdm", "gdn", "gdo", "gdq", "gdr", "gds", "gdt", "gdu", "gdx", "gea",
			"geb", "gec", "ged", "geg", "geh", "gei", "gej", "gek", "gel", "geq", "ges", "gev", "gew", "gex", "gey",
			"gez", "gfk", "gft", "gga", "ggb", "ggd", "gge", "ggg", "ggk", "ggl", "ggt", "ggu", "ggw", "gha", "ghc",
			"ghe", "ghh", "ghk", "ghl", "ghn", "gho", "ghr", "ghs", "ght", "gia", "gib", "gic", "gid", "gie", "gig",
			"gih", "gil", "gim", "gin", "gip", "giq", "gir", "gis", "git", "giu", "giw", "gix", "giy", "giz", "gji",
			"gjk", "gjm", "gjn", "gjr", "gju", "gka", "gke", "gkn", "gko", "gkp", "gku", "gl", "gla", "glc", "gld",
			"gle", "glg", "glh", "gli", "glj", "glk", "gll", "glo", "glr", "glu", "glv", "glw", "gly", "gma", "gmb",
			"gmd", "gmg", "gmh", "gml", "gmm", "gmn", "gmu", "gmv", "gmx", "gmy", "gmz", "gn", "gna", "gnb", "gnc",
			"gnd", "gne", "gng", "gnh", "gni", "gnk", "gnl", "gnm", "gnn", "gno", "gnq", "gnr", "gnt", "gnu", "gnw",
			"gnz", "goa", "gob", "goc", "god", "goe", "gof", "gog", "goh", "goi", "goj", "gok", "gol", "gom", "gon",
			"goo", "gop", "goq", "gor", "gos", "got", "gou", "gow", "gox", "goy", "goz", "gpa", "gpe", "gpn", "gqa",
			"gqi", "gqn", "gqr", "gqu", "gra", "grb", "grc", "grd", "grg", "grh", "gri", "grj", "grm", "grn", "gro",
			"grq", "grr", "grs", "grt", "gru", "grv", "grw", "grx", "gry", "grz", "gse", "gsg", "gsl", "gsm", "gsn",
			"gso", "gsp", "gss", "gsw", "gta", "gtu", "gu", "gua", "gub", "guc", "gud", "gue", "guf", "gug", "guh",
			"gui", "guj", "guk", "gul", "gum", "gun", "guo", "gup", "guq", "gur", "gus", "gut", "guu", "guw", "gux",
			"guz", "gv", "gva", "gvc", "gve", "gvf", "gvj", "gvl", "gvm", "gvn", "gvo", "gvp", "gvr", "gvs", "gvy",
			"gwa", "gwb", "gwc", "gwd", "gwe", "gwf", "gwg", "gwi", "gwj", "gwm", "gwn", "gwr", "gwt", "gwu", "gww",
			"gwx", "gxx", "gya", "gyb", "gyd", "gye", "gyf", "gyg", "gyi", "gyl", "gym", "gyn", "gyr", "gyy", "gza",
			"gzi", "gzn"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_H = new HashSet<>(Arrays.asList("ha", "haa", "hab", "hac", "had", "hae",
			"haf", "hag", "hah", "hai", "haj", "hak", "hal", "ham", "han", "hao", "hap", "haq", "har", "has", "hat",
			"hau", "hav", "haw", "hax", "hay", "haz", "hba", "hbb", "hbn", "hbo", "hbs", "hbu", "hca", "hch", "hdn",
			"hds", "hdy", "he", "hea", "heb", "hed", "heg", "heh", "hei", "hem", "her", "hgm", "hgw", "hhi", "hhr",
			"hhy", "hi", "hia", "hib", "hid", "hif", "hig", "hih", "hii", "hij", "hik", "hil", "hin", "hio", "hir",
			"hit", "hiw", "hix", "hji", "hka", "hke", "hkk", "hks", "hla", "hlb", "hld", "hle", "hlt", "hlu", "hma",
			"hmb", "hmc", "hmd", "hme", "hmf", "hmg", "hmh", "hmi", "hmj", "hmk", "hml", "hmm", "hmn", "hmo", "hmp",
			"hmq", "hmr", "hms", "hmt", "hmu", "hmv", "hmw", "hmy", "hmz", "hna", "hnd", "hne", "hnh", "hni", "hnj",
			"hnn", "hno", "hns", "hnu", "ho", "hoa", "hob", "hoc", "hod", "hoe", "hoh", "hoi", "hoj", "hol", "hom",
			"hoo", "hop", "hor", "hos", "hot", "hov", "how", "hoy", "hoz", "hpo", "hps", "hr", "hra", "hrc", "hre",
			"hrk", "hrm", "hro", "hrp", "hrt", "hru", "hrv", "hrw", "hrx", "hrz", "hsb", "hsh", "hsl", "hsn", "hss",
			"ht", "hti", "hto", "hts", "htu", "htx", "hu", "hub", "huc", "hud", "hue", "huf", "hug", "huh", "hui",
			"huj", "huk", "hul", "hum", "hun", "huo", "hup", "huq", "hur", "hus", "hut", "huu", "huv", "huw", "hux",
			"huy", "huz", "hvc", "hve", "hvk", "hvn", "hvv", "hwa", "hwc", "hwo", "hy", "hya", "hye", "hz"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_I = new HashSet<>(Arrays.asList("ia", "iai", "ian", "iar", "iba", "ibb",
			"ibd", "ibe", "ibg", "ibh", "ibl", "ibm", "ibn", "ibo", "ibr", "ibu", "iby", "ica", "ich", "icl", "icr",
			"id", "ida", "idb", "idc", "idd", "ide", "idi", "ido", "idr", "ids", "idt", "idu", "ie", "ifa", "ifb",
			"ife", "iff", "ifk", "ifm", "ifu", "ify", "ig", "igb", "ige", "igg", "igl", "igm", "ign", "igo", "igs",
			"igw", "ihb", "ihi", "ihp", "ihw", "ii", "iii", "iin", "ijc", "ije", "ijj", "ijn", "ijs", "ik", "ike",
			"iki", "ikk", "ikl", "iko", "ikp", "ikr", "iks", "ikt", "iku", "ikv", "ikw", "ikx", "ikz", "ila", "ilb",
			"ile", "ilg", "ili", "ilk", "ilm", "ilo", "ilp", "ils", "ilu", "ilv", "ima", "imi", "iml", "imn", "imo",
			"imr", "ims", "imy", "ina", "inb", "ind", "ing", "inh", "inj", "inl", "inm", "inn", "ino", "inp", "ins",
			"int", "inz", "io", "ior", "iou", "iow", "ipi", "ipk", "ipo", "iqu", "iqw", "ire", "irh", "iri", "irk",
			"irn", "irr", "iru", "irx", "iry", "is", "isa", "isc", "isd", "ise", "isg", "ish", "isi", "isk", "isl",
			"ism", "isn", "iso", "isr", "ist", "isu", "it", "ita", "itb", "itd", "ite", "iti", "itk", "itl", "itm",
			"ito", "itr", "its", "itt", "itv", "itw", "itx", "ity", "itz", "iu", "ium", "ivb", "ivv", "iwk", "iwm",
			"iwo", "iws", "ixc", "ixl", "iya", "iyo", "iyx", "izh", "izr", "izz"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_J = new HashSet<>(Arrays.asList("ja", "jaa", "jab", "jac", "jad", "jae",
			"jaf", "jah", "jaj", "jak", "jal", "jam", "jan", "jao", "jaq", "jas", "jat", "jau", "jav", "jax", "jay",
			"jaz", "jbe", "jbi", "jbj", "jbk", "jbn", "jbo", "jbr", "jbt", "jbu", "jbw", "jcs", "jct", "jda", "jdg",
			"jdt", "jeb", "jee", "jeh", "jei", "jek", "jel", "jen", "jer", "jet", "jeu", "jgb", "jge", "jgk", "jgo",
			"jhi", "jhs", "jia", "jib", "jic", "jid", "jie", "jig", "jih", "jii", "jil", "jim", "jio", "jiq", "jit",
			"jiu", "jiv", "jiy", "jje", "jjr", "jka", "jkm", "jko", "jkp", "jkr", "jku", "jle", "jls", "jma", "jmb",
			"jmc", "jmd", "jmi", "jml", "jmn", "jmr", "jms", "jmw", "jmx", "jna", "jnd", "jng", "jni", "jnj", "jnl",
			"jns", "job", "jod", "jog", "jor", "jos", "jow", "jpa", "jpn", "jpr", "jqr", "jra", "jrb", "jrr", "jrt",
			"jru", "jsl", "jua", "jub", "juc", "jud", "juh", "jui", "juk", "jul", "jum", "jun", "juo", "jup", "jur",
			"jus", "jut", "juu", "juw", "juy", "jv", "jvd", "jvn", "jwi", "jya", "jye", "jyy"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_K = new HashSet<>(Arrays.asList("ka", "kaa", "kab", "kac", "kad", "kae",
			"kaf", "kag", "kah", "kai", "kaj", "kak", "kal", "kam", "kan", "kao", "kap", "kaq", "kas", "kat", "kau",
			"kav", "kaw", "kax", "kay", "kaz", "kba", "kbb", "kbc", "kbd", "kbe", "kbg", "kbh", "kbi", "kbj", "kbk",
			"kbl", "kbm", "kbn", "kbo", "kbp", "kbq", "kbr", "kbs", "kbt", "kbu", "kbv", "kbw", "kbx", "kby", "kbz",
			"kca", "kcb", "kcc", "kcd", "kce", "kcf", "kcg", "kch", "kci", "kcj", "kck", "kcl", "kcm", "kcn", "kco",
			"kcp", "kcq", "kcr", "kcs", "kct", "kcu", "kcv", "kcw", "kcx", "kcy", "kcz", "kda", "kdc", "kdd", "kde",
			"kdf", "kdg", "kdh", "kdi", "kdj", "kdk", "kdl", "kdm", "kdn", "kdp", "kdq", "kdr", "kdt", "kdu", "kdw",
			"kdx", "kdy", "kdz", "kea", "keb", "kec", "ked", "kee", "kef", "keg", "keh", "kei", "kej", "kek", "kel",
			"kem", "ken", "keo", "kep", "keq", "ker", "kes", "ket", "keu", "kev", "kew", "kex", "key", "kez", "kfa",
			"kfb", "kfc", "kfd", "kfe", "kff", "kfg", "kfh", "kfi", "kfj", "kfk", "kfl", "kfm", "kfn", "kfo", "kfp",
			"kfq", "kfr", "kfs", "kft", "kfu", "kfv", "kfw", "kfx", "kfy", "kfz", "kg", "kga", "kgb", "kge", "kgf",
			"kgg", "kgi", "kgj", "kgk", "kgl", "kgm", "kgn", "kgo", "kgp", "kgq", "kgr", "kgs", "kgt", "kgu", "kgv",
			"kgw", "kgx", "kgy", "kha", "khb", "khc", "khd", "khe", "khf", "khg", "khh", "khj", "khk", "khl", "khm",
			"khn", "kho", "khp", "khq", "khr", "khs", "kht", "khu", "khv", "khw", "khx", "khy", "khz", "ki", "kia",
			"kib", "kic", "kid", "kie", "kif", "kig", "kih", "kii", "kij", "kik", "kil", "kim", "kin", "kio", "kip",
			"kiq", "kir", "kis", "kit", "kiu", "kiv", "kiw", "kix", "kiy", "kiz", "kj", "kja", "kjb", "kjc", "kjd",
			"kje", "kjf", "kjg", "kjh", "kji", "kjj", "kjk", "kjl", "kjm", "kjn", "kjo", "kjp", "kjq", "kjr", "kjs",
			"kjt", "kju", "kjv", "kjx", "kjy", "kjz", "kk", "kka", "kkb", "kkc", "kkd", "kke", "kkf", "kkg", "kkh",
			"kki", "kkj", "kkk", "kkl", "kkm", "kkn", "kko", "kkp", "kkq", "kkr", "kks", "kkt", "kku", "kkv", "kkw",
			"kkx", "kky", "kkz", "kl", "kla", "klb", "klc", "kld", "kle", "klf", "klg", "klh", "kli", "klj", "klk",
			"kll", "klm", "kln", "klo", "klp", "klq", "klr", "kls", "klt", "klu", "klv", "klw", "klx", "kly", "klz",
			"km", "kma", "kmb", "kmc", "kmd", "kme", "kmf", "kmg", "kmh", "kmi", "kmj", "kmk", "kml", "kmm", "kmn",
			"kmo", "kmp", "kmq", "kmr", "kms", "kmt", "kmu", "kmv", "kmw", "kmx", "kmy", "kmz", "kn", "kna", "knb",
			"knc", "knd", "kne", "knf", "kng", "kni", "knj", "knk", "knl", "knm", "knn", "kno", "knp", "knq", "knr",
			"kns", "knt", "knu", "knv", "knw", "knx", "kny", "knz", "ko", "koa", "koc", "kod", "koe", "kof", "kog",
			"koh", "koi", "kok", "kol", "kom", "kon", "koo", "kop", "koq", "kor", "kos", "kot", "kou", "kov", "kow",
			"koy", "koz", "kpa", "kpb", "kpc", "kpd", "kpe", "kpf", "kpg", "kph", "kpi", "kpj", "kpk", "kpl", "kpm",
			"kpn", "kpo", "kpq", "kpr", "kps", "kpt", "kpu", "kpv", "kpw", "kpx", "kpy", "kpz", "kqa", "kqb", "kqc",
			"kqd", "kqe", "kqf", "kqg", "kqh", "kqi", "kqj", "kqk", "kql", "kqm", "kqn", "kqo", "kqp", "kqq", "kqr",
			"kqs", "kqt", "kqu", "kqv", "kqw", "kqx", "kqy", "kqz", "kr", "kra", "krb", "krc", "krd", "kre", "krf",
			"krh", "kri", "krj", "krk", "krl", "krn", "krp", "krr", "krs", "krt", "kru", "krv", "krw", "krx", "kry",
			"krz", "ks", "ksa", "ksb", "ksc", "ksd", "kse", "ksf", "ksg", "ksh", "ksi", "ksj", "ksk", "ksl", "ksm",
			"ksn", "kso", "ksp", "ksq", "ksr", "kss", "kst", "ksu", "ksv", "ksw", "ksx", "ksy", "ksz", "kta", "ktb",
			"ktc", "ktd", "kte", "ktf", "ktg", "kth", "kti", "ktj", "ktk", "ktl", "ktm", "ktn", "kto", "ktp", "ktq",
			"kts", "ktt", "ktu", "ktv", "ktw", "ktx", "kty", "ktz", "ku", "kua", "kub", "kuc", "kud", "kue", "kuf",
			"kug", "kuh", "kui", "kuj", "kuk", "kul", "kum", "kun", "kuo", "kup", "kuq", "kur", "kus", "kut", "kuu",
			"kuv", "kuw", "kux", "kuy", "kuz", "kv", "kva", "kvb", "kvc", "kvd", "kve", "kvf", "kvg", "kvh", "kvi",
			"kvj", "kvk", "kvl", "kvm", "kvn", "kvo", "kvp", "kvq", "kvr", "kvt", "kvu", "kvv", "kvw", "kvx", "kvy",
			"kvz", "kw", "kwa", "kwb", "kwc", "kwd", "kwe", "kwf", "kwg", "kwh", "kwi", "kwj", "kwk", "kwl", "kwm",
			"kwn", "kwo", "kwp", "kwr", "kws", "kwt", "kwu", "kwv", "kww", "kwx", "kwy", "kwz", "kxa", "kxb", "kxc",
			"kxd", "kxf", "kxh", "kxi", "kxj", "kxk", "kxl", "kxm", "kxn", "kxo", "kxp", "kxq", "kxr", "kxs", "kxt",
			"kxu", "kxv", "kxw", "kxx", "kxy", "kxz", "ky", "kya", "kyb", "kyc", "kyd", "kye", "kyf", "kyg", "kyh",
			"kyi", "kyj", "kyk", "kyl", "kym", "kyn", "kyo", "kyp", "kyq", "kyr", "kys", "kyt", "kyu", "kyv", "kyw",
			"kyx", "kyy", "kyz", "kza", "kzb", "kzc", "kzd", "kze", "kzf", "kzg", "kzi", "kzk", "kzl", "kzm", "kzn",
			"kzo", "kzp", "kzq", "kzr", "kzs", "kzu", "kzv", "kzw", "kzx", "kzy", "kzz"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_L = new HashSet<>(Arrays.asList("la", "laa", "lab", "lac", "lad", "lae",
			"laf", "lag", "lah", "lai", "laj", "lak", "lal", "lam", "lan", "lao", "lap", "laq", "lar", "las", "lat",
			"lau", "lav", "law", "lax", "lay", "laz", "lb", "lba", "lbb", "lbc", "lbe", "lbf", "lbg", "lbi", "lbj",
			"lbk", "lbl", "lbm", "lbn", "lbo", "lbq", "lbr", "lbs", "lbt", "lbu", "lbv", "lbw", "lbx", "lby", "lbz",
			"lcc", "lcd", "lce", "lcf", "lch", "lcl", "lcm", "lcp", "lcq", "lcs", "lda", "ldb", "ldd", "ldg", "ldh",
			"ldi", "ldj", "ldk", "ldl", "ldm", "ldn", "ldo", "ldp", "ldq", "lea", "leb", "lec", "led", "lee", "lef",
			"leh", "lei", "lej", "lek", "lel", "lem", "len", "leo", "lep", "leq", "ler", "les", "let", "leu", "lev",
			"lew", "lex", "ley", "lez", "lfa", "lfn", "lg", "lga", "lgb", "lgg", "lgh", "lgi", "lgk", "lgl", "lgm",
			"lgn", "lgq", "lgr", "lgt", "lgu", "lgz", "lha", "lhh", "lhi", "lhl", "lhm", "lhn", "lhp", "lhs", "lht",
			"lhu", "li", "lia", "lib", "lic", "lid", "lie", "lif", "lig", "lih", "lij", "lik", "lil", "lim", "lin",
			"lio", "lip", "liq", "lir", "lis", "lit", "liu", "liv", "liw", "lix", "liy", "liz", "lja", "lje", "lji",
			"ljl", "ljp", "ljw", "ljx", "lka", "lkb", "lkc", "lkd", "lke", "lkh", "lki", "lkj", "lkl", "lkm", "lkn",
			"lko", "lkr", "lks", "lkt", "lku", "lky", "lla", "llb", "llc", "lld", "lle", "llf", "llg", "llh", "lli",
			"llj", "llk", "lll", "llm", "lln", "llo", "llp", "llq", "lls", "llu", "llx", "lma", "lmb", "lmc", "lmd",
			"lme", "lmf", "lmg", "lmh", "lmi", "lmj", "lmk", "lml", "lmn", "lmo", "lmp", "lmq", "lmr", "lmu", "lmv",
			"lmw", "lmx", "lmy", "lmz", "ln", "lna", "lnb", "lnd", "lng", "lnh", "lni", "lnj", "lnl", "lnm", "lnn",
			"lno", "lns", "lnu", "lnw", "lnz", "lo", "loa", "lob", "loc", "loe", "lof", "log", "loh", "loi", "loj",
			"lok", "lol", "lom", "lon", "loo", "lop", "loq", "lor", "los", "lot", "lou", "lov", "low", "lox", "loy",
			"loz", "lpa", "lpe", "lpn", "lpo", "lpx", "lra", "lrc", "lre", "lrg", "lri", "lrk", "lrl", "lrm", "lrn",
			"lro", "lrr", "lrt", "lrv", "lrz", "lsa", "lsd", "lse", "lsg", "lsh", "lsi", "lsl", "lsm", "lso", "lsp",
			"lsr", "lss", "lst", "lsy", "lt", "ltc", "ltg", "lth", "lti", "ltn", "lto", "lts", "ltu", "ltz", "lu",
			"lua", "lub", "luc", "lud", "lue", "luf", "lug", "lui", "luj", "luk", "lul", "lum", "lun", "luo", "lup",
			"luq", "lur", "lus", "lut", "luu", "luv", "luw", "luy", "luz", "lv", "lva", "lvk", "lvs", "lvu", "lwa",
			"lwe", "lwg", "lwh", "lwl", "lwm", "lwo", "lwt", "lwu", "lww", "lya", "lyg", "lyn", "lzh", "lzl", "lzn",
			"lzz"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_M = new HashSet<>(Arrays.asList("maa", "mab", "mad", "mae", "maf", "mag",
			"mah", "mai", "maj", "mak", "mal", "mam", "man", "maq", "mar", "mas", "mat", "mau", "mav", "maw", "max",
			"maz", "mba", "mbb", "mbc", "mbd", "mbe", "mbf", "mbh", "mbi", "mbj", "mbk", "mbl", "mbm", "mbn", "mbo",
			"mbp", "mbq", "mbr", "mbs", "mbt", "mbu", "mbv", "mbw", "mbx", "mby", "mbz", "mca", "mcb", "mcc", "mcd",
			"mce", "mcf", "mcg", "mch", "mci", "mcj", "mck", "mcl", "mcm", "mcn", "mco", "mcp", "mcq", "mcr", "mcs",
			"mct", "mcu", "mcv", "mcw", "mcx", "mcy", "mcz", "mda", "mdb", "mdc", "mdd", "mde", "mdf", "mdg", "mdh",
			"mdi", "mdj", "mdk", "mdl", "mdm", "mdn", "mdp", "mdq", "mdr", "mds", "mdt", "mdu", "mdv", "mdw", "mdx",
			"mdy", "mdz", "mea", "meb", "mec", "med", "mee", "mef", "meh", "mei", "mej", "mek", "mel", "mem", "men",
			"meo", "mep", "meq", "mer", "mes", "met", "meu", "mev", "mew", "mey", "mez", "mfa", "mfb", "mfc", "mfd",
			"mfe", "mff", "mfg", "mfh", "mfi", "mfj", "mfk", "mfl", "mfm", "mfn", "mfo", "mfp", "mfq", "mfr", "mfs",
			"mft", "mfu", "mfv", "mfw", "mfx", "mfy", "mfz", "mg", "mga", "mgb", "mgc", "mgd", "mge", "mgf", "mgg",
			"mgh", "mgi", "mgj", "mgk", "mgl", "mgm", "mgn", "mgo", "mgp", "mgq", "mgr", "mgs", "mgt", "mgu", "mgv",
			"mgw", "mgy", "mgz", "mh", "mha", "mhb", "mhc", "mhd", "mhe", "mhf", "mhg", "mhi", "mhj", "mhk", "mhl",
			"mhm", "mhn", "mho", "mhp", "mhq", "mhr", "mhs", "mht", "mhu", "mhw", "mhx", "mhy", "mhz", "mi", "mia",
			"mib", "mic", "mid", "mie", "mif", "mig", "mih", "mii", "mij", "mik", "mil", "mim", "min", "mio", "mip",
			"miq", "mir", "mis", "mit", "miu", "miw", "mix", "miy", "miz", "mjb", "mjc", "mjd", "mje", "mjg", "mjh",
			"mji", "mjj", "mjk", "mjl", "mjm", "mjn", "mjo", "mjp", "mjq", "mjr", "mjs", "mjt", "mju", "mjv", "mjw",
			"mjx", "mjy", "mjz", "mk", "mka", "mkb", "mkc", "mkd", "mke", "mkf", "mkg", "mki", "mkj", "mkk", "mkl",
			"mkm", "mkn", "mko", "mkp", "mkq", "mkr", "mks", "mkt", "mku", "mkv", "mkw", "mkx", "mky", "mkz", "ml",
			"mla", "mlb", "mlc", "mle", "mlf", "mlg", "mlh", "mli", "mlj", "mlk", "mll", "mlm", "mln", "mlo", "mlp",
			"mlq", "mlr", "mls", "mlt", "mlu", "mlv", "mlw", "mlx", "mlz", "mma", "mmb", "mmc", "mmd", "mme", "mmf",
			"mmg", "mmh", "mmi", "mmj", "mmk", "mml", "mmm", "mmn", "mmo", "mmp", "mmq", "mmr", "mmt", "mmu", "mmv",
			"mmw", "mmx", "mmy", "mmz", "mn", "mna", "mnb", "mnc", "mnd", "mne", "mnf", "mng", "mnh", "mni", "mnj",
			"mnk", "mnl", "mnm", "mnn", "mnp", "mnq", "mnr", "mns", "mnu", "mnv", "mnw", "mnx", "mny", "mnz", "moa",
			"moc", "mod", "moe", "mog", "moh", "moi", "moj", "mok", "mom", "mon", "moo", "mop", "moq", "mor", "mos",
			"mot", "mou", "mov", "mow", "mox", "moy", "moz", "mpa", "mpb", "mpc", "mpd", "mpe", "mpg", "mph", "mpi",
			"mpj", "mpk", "mpl", "mpm", "mpn", "mpo", "mpp", "mpq", "mpr", "mps", "mpt", "mpu", "mpv", "mpw", "mpx",
			"mpy", "mpz", "mqa", "mqb", "mqc", "mqe", "mqf", "mqg", "mqh", "mqi", "mqj", "mqk", "mql", "mqm", "mqn",
			"mqo", "mqp", "mqq", "mqr", "mqs", "mqt", "mqu", "mqv", "mqw", "mqx", "mqy", "mqz", "mr", "mra", "mrb",
			"mrc", "mrd", "mre", "mrf", "mrg", "mrh", "mri", "mrj", "mrk", "mrl", "mrm", "mrn", "mro", "mrp", "mrq",
			"mrr", "mrs", "mrt", "mru", "mrv", "mrw", "mrx", "mry", "mrz", "ms", "msa", "msb", "msc", "msd", "mse",
			"msf", "msg", "msh", "msi", "msj", "msk", "msl", "msm", "msn", "mso", "msp", "msq", "msr", "mss", "msu",
			"msv", "msw", "msx", "msy", "msz", "mt", "mta", "mtb", "mtc", "mtd", "mte", "mtf", "mtg", "mth", "mti",
			"mtj", "mtk", "mtl", "mtm", "mtn", "mto", "mtp", "mtq", "mtr", "mts", "mtt", "mtu", "mtv", "mtw", "mtx",
			"mty", "mua", "mub", "muc", "mud", "mue", "mug", "muh", "mui", "muj", "muk", "mul", "mum", "muo", "mup",
			"muq", "mur", "mus", "mut", "muu", "muv", "mux", "muy", "muz", "mva", "mvb", "mvd", "mve", "mvf", "mvg",
			"mvh", "mvi", "mvk", "mvl", "mvm", "mvn", "mvo", "mvp", "mvq", "mvr", "mvs", "mvt", "mvu", "mvv", "mvw",
			"mvx", "mvy", "mvz", "mwa", "mwb", "mwc", "mwe", "mwf", "mwg", "mwh", "mwi", "mwk", "mwl", "mwm", "mwn",
			"mwo", "mwp", "mwq", "mwr", "mws", "mwt", "mwu", "mwv", "mww", "mwx", "mwy", "mwz", "mxa", "mxb", "mxc",
			"mxd", "mxe", "mxf", "mxg", "mxh", "mxi", "mxj", "mxk", "mxl", "mxm", "mxn", "mxo", "mxp", "mxq", "mxr",
			"mxs", "mxt", "mxu", "mxv", "mxw", "mxx", "mxy", "mxz", "my", "mya", "myb", "myc", "myd", "mye", "myf",
			"myg", "myh", "myi", "myj", "myk", "myl", "mym", "myo", "myp", "myr", "mys", "myu", "myv", "myw", "myx",
			"myy", "myz", "mza", "mzb", "mzc", "mzd", "mze", "mzg", "mzh", "mzi", "mzj", "mzk", "mzl", "mzm", "mzn",
			"mzo", "mzp", "mzq", "mzr", "mzs", "mzt", "mzu", "mzv", "mzw", "mzx", "mzy", "mzz"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_N = new HashSet<>(Arrays.asList("na", "naa", "nab", "nac", "nae", "naf",
			"nag", "naj", "nak", "nal", "nam", "nan", "nao", "nap", "naq", "nar", "nas", "nat", "nau", "nav", "naw",
			"nax", "nay", "naz", "nb", "nba", "nbb", "nbc", "nbd", "nbe", "nbg", "nbh", "nbi", "nbj", "nbk", "nbl",
			"nbm", "nbn", "nbo", "nbp", "nbq", "nbr", "nbs", "nbt", "nbu", "nbv", "nbw", "nby", "nca", "ncb", "ncc",
			"ncd", "nce", "ncf", "ncg", "nch", "nci", "ncj", "nck", "ncl", "ncm", "ncn", "nco", "ncp", "ncq", "ncr",
			"ncs", "nct", "ncu", "ncx", "ncz", "nd", "nda", "ndb", "ndc", "ndd", "nde", "ndf", "ndg", "ndh", "ndi",
			"ndj", "ndk", "ndl", "ndm", "ndn", "ndo", "ndp", "ndq", "ndr", "nds", "ndt", "ndu", "ndv", "ndw", "ndx",
			"ndy", "ndz", "ne", "nea", "neb", "nec", "ned", "nee", "nef", "neg", "neh", "nei", "nej", "nek", "nem",
			"nen", "neo", "nep", "neq", "ner", "nes", "net", "neu", "nev", "new", "nex", "ney", "nez", "nfa", "nfd",
			"nfl", "nfr", "nfu", "ng", "nga", "ngb", "ngc", "ngd", "nge", "ngg", "ngh", "ngi", "ngj", "ngk", "ngl",
			"ngm", "ngn", "ngo", "ngp", "ngq", "ngr", "ngs", "ngt", "ngu", "ngv", "ngw", "ngx", "ngy", "ngz", "nha",
			"nhb", "nhc", "nhd", "nhe", "nhf", "nhg", "nhh", "nhi", "nhk", "nhm", "nhn", "nho", "nhp", "nhq", "nhr",
			"nht", "nhu", "nhv", "nhw", "nhx", "nhy", "nhz", "nia", "nib", "nid", "nie", "nif", "nig", "nih", "nii",
			"nij", "nik", "nil", "nim", "nin", "nio", "niq", "nir", "nis", "nit", "niu", "niv", "niw", "nix", "niy",
			"niz", "nja", "njb", "njd", "njh", "nji", "njj", "njl", "njm", "njn", "njo", "njr", "njs", "njt", "nju",
			"njx", "njy", "njz", "nka", "nkb", "nkc", "nkd", "nke", "nkf", "nkg", "nkh", "nki", "nkj", "nkk", "nkm",
			"nkn", "nko", "nkp", "nkq", "nkr", "nks", "nkt", "nku", "nkv", "nkw", "nkx", "nkz", "nl", "nla", "nlc",
			"nld", "nle", "nlg", "nli", "nlj", "nlk", "nll", "nlo", "nlq", "nlu", "nlv", "nlw", "nlx", "nly", "nlz",
			"nma", "nmb", "nmc", "nmd", "nme", "nmf", "nmg", "nmh", "nmi", "nmj", "nmk", "nml", "nmm", "nmn", "nmo",
			"nmp", "nmq", "nmr", "nms", "nmt", "nmu", "nmv", "nmw", "nmx", "nmy", "nmz", "nn", "nna", "nnb", "nnc",
			"nnd", "nne", "nnf", "nng", "nnh", "nni", "nnj", "nnk", "nnl", "nnm", "nnn", "nno", "nnp", "nnq", "nnr",
			"nns", "nnt", "nnu", "nnv", "nnw", "nny", "nnz", "no", "noa", "nob", "noc", "nod", "noe", "nof", "nog",
			"noh", "noi", "noj", "nok", "nol", "nom", "non", "nop", "noq", "nor", "nos", "not", "nou", "nov", "now",
			"noy", "noz", "npa", "npb", "npg", "nph", "npi", "npl", "npn", "npo", "nps", "npu", "npx", "npy", "nqg",
			"nqk", "nql", "nqm", "nqn", "nqo", "nqq", "nqy", "nr", "nra", "nrb", "nrc", "nre", "nrf", "nrg", "nri",
			"nrk", "nrl", "nrm", "nrn", "nrp", "nrr", "nrt", "nru", "nrx", "nrz", "nsa", "nsc", "nsd", "nse", "nsf",
			"nsg", "nsh", "nsi", "nsk", "nsl", "nsm", "nsn", "nso", "nsp", "nsq", "nsr", "nss", "nst", "nsu", "nsv",
			"nsw", "nsx", "nsy", "nsz", "ntd", "nte", "ntg", "nti", "ntj", "ntk", "ntm", "nto", "ntp", "ntr", "ntu",
			"ntw", "ntx", "nty", "ntz", "nua", "nuc", "nud", "nue", "nuf", "nug", "nuh", "nui", "nuj", "nuk", "nul",
			"num", "nun", "nuo", "nup", "nuq", "nur", "nus", "nut", "nuu", "nuv", "nuw", "nux", "nuy", "nuz", "nv",
			"nvh", "nvm", "nvo", "nwa", "nwb", "nwc", "nwe", "nwg", "nwi", "nwm", "nwo", "nwr", "nwx", "nwy", "nxa",
			"nxd", "nxe", "nxg", "nxi", "nxk", "nxl", "nxm", "nxn", "nxo", "nxq", "nxr", "nxu", "nxx", "ny", "nya",
			"nyb", "nyc", "nyd", "nye", "nyf", "nyg", "nyh", "nyi", "nyj", "nyk", "nyl", "nym", "nyn", "nyo", "nyp",
			"nyq", "nyr", "nys", "nyt", "nyu", "nyv", "nyw", "nyx", "nyy", "nza", "nzb", "nzi", "nzk", "nzm", "nzs",
			"nzu", "nzy", "nzz"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_O = new HashSet<>(Arrays.asList("oaa", "oac", "oar", "oav", "obi", "obk",
			"obl", "obm", "obo", "obr", "obt", "obu", "oc", "oca", "och", "oci", "oco", "ocu", "oda", "odk", "odt",
			"odu", "ofo", "ofs", "ofu", "ogb", "ogc", "oge", "ogg", "ogo", "ogu", "oht", "ohu", "oia", "oin", "oj",
			"ojb", "ojc", "ojg", "oji", "ojp", "ojs", "ojv", "ojw", "oka", "okb", "okd", "oke", "okg", "okh", "oki",
			"okj", "okk", "okl", "okm", "okn", "oko", "okr", "oks", "oku", "okv", "okx", "ola", "old", "ole", "olk",
			"olm", "olo", "olr", "olt", "olu", "om", "oma", "omb", "omc", "omg", "omi", "omk", "oml", "omn", "omo",
			"omp", "omr", "omt", "omu", "omw", "omx", "ona", "onb", "one", "ong", "oni", "onj", "onk", "onn", "ono",
			"onp", "onr", "ons", "ont", "onu", "onw", "onx", "ood", "oog", "oon", "oor", "oos", "opa", "opk", "opm",
			"opo", "opt", "opy", "or", "ora", "orc", "ore", "org", "orh", "ori", "orm", "orn", "oro", "orr", "ors",
			"ort", "oru", "orv", "orw", "orx", "ory", "orz", "os", "osa", "osc", "osi", "oso", "osp", "oss", "ost",
			"osu", "osx", "ota", "otb", "otd", "ote", "oti", "otk", "otl", "otm", "otn", "otq", "otr", "ots", "ott",
			"otu", "otw", "otx", "oty", "otz", "oua", "oub", "oue", "oui", "oum", "ovd", "owi", "owl", "oyb", "oyd",
			"oym", "oyy", "ozm"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_P = new HashSet<>(Arrays.asList("pa", "pab", "pac", "pad", "pae", "paf",
			"pag", "pah", "pai", "pak", "pal", "pam", "pan", "pao", "pap", "paq", "par", "pas", "pat", "pau", "pav",
			"paw", "pax", "pay", "paz", "pbb", "pbc", "pbe", "pbf", "pbg", "pbh", "pbi", "pbl", "pbn", "pbo", "pbp",
			"pbr", "pbs", "pbt", "pbu", "pbv", "pby", "pca", "pcb", "pcc", "pcd", "pce", "pcf", "pcg", "pch", "pci",
			"pcj", "pck", "pcl", "pcm", "pcn", "pcp", "pcw", "pda", "pdc", "pdi", "pdn", "pdo", "pdt", "pdu", "pea",
			"peb", "ped", "pee", "pef", "peg", "peh", "pei", "pej", "pek", "pel", "pem", "peo", "pep", "peq", "pes",
			"pev", "pex", "pey", "pez", "pfa", "pfe", "pfl", "pga", "pgd", "pgg", "pgi", "pgk", "pgl", "pgn", "pgs",
			"pgu", "pgz", "pha", "phd", "phg", "phh", "phk", "phl", "phm", "phn", "pho", "phq", "phr", "pht", "phu",
			"phv", "phw", "pi", "pia", "pib", "pic", "pid", "pie", "pif", "pig", "pih", "pii", "pij", "pil", "pim",
			"pin", "pio", "pip", "pir", "pis", "pit", "piu", "piv", "piw", "pix", "piy", "piz", "pjt", "pka", "pkb",
			"pkc", "pkg", "pkh", "pkn", "pko", "pkp", "pkr", "pks", "pkt", "pku", "pl", "pla", "plb", "plc", "pld",
			"ple", "plg", "plh", "pli", "plj", "plk", "pll", "pln", "plo", "plp", "plq", "plr", "pls", "plt", "plu",
			"plv", "plw", "ply", "plz", "pma", "pmb", "pmd", "pme", "pmf", "pmh", "pmi", "pmj", "pmk", "pml", "pmm",
			"pmn", "pmo", "pmq", "pmr", "pms", "pmt", "pmw", "pmx", "pmy", "pmz", "pna", "pnb", "pnc", "pne", "png",
			"pnh", "pni", "pnj", "pnk", "pnl", "pnm", "pnn", "pno", "pnp", "pnq", "pnr", "pns", "pnt", "pnu", "pnv",
			"pnw", "pnx", "pny", "pnz", "poc", "poe", "pof", "pog", "poh", "poi", "pok", "pol", "pom", "pon", "poo",
			"pop", "poq", "por", "pos", "pot", "pov", "pow", "pox", "poy", "ppe", "ppi", "ppk", "ppl", "ppm", "ppn",
			"ppo", "ppp", "ppq", "pps", "ppt", "ppu", "pqa", "pqm", "prc", "prd", "pre", "prf", "prg", "prh", "pri",
			"prk", "prl", "prm", "prn", "pro", "prp", "prq", "prr", "prs", "prt", "pru", "prw", "prx", "prz", "ps",
			"psa", "psc", "psd", "pse", "psg", "psh", "psi", "psl", "psm", "psn", "pso", "psp", "psq", "psr", "pss",
			"pst", "psu", "psw", "psy", "pt", "pta", "pth", "pti", "ptn", "pto", "ptp", "ptq", "ptr", "ptt", "ptu",
			"ptv", "ptw", "pty", "pua", "pub", "puc", "pud", "pue", "puf", "pug", "pui", "puj", "pum", "puo", "pup",
			"puq", "pur", "pus", "put", "puu", "puw", "pux", "puy", "pwa", "pwb", "pwg", "pwi", "pwm", "pwn", "pwo",
			"pwr", "pww", "pxm", "pye", "pym", "pyn", "pys", "pyu", "pyx", "pyy", "pzn"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_Q = new HashSet<>(Arrays.asList("qu", "qua", "qub", "quc", "qud", "que",
			"quf", "qug", "quh", "qui", "quk", "qul", "qum", "qun", "qup", "quq", "qur", "qus", "quv", "quw", "qux",
			"quy", "quz", "qva", "qvc", "qve", "qvh", "qvi", "qvj", "qvl", "qvm", "qvn", "qvo", "qvp", "qvs", "qvw",
			"qvy", "qvz", "qwa", "qwc", "qwh", "qwm", "qws", "qwt", "qxa", "qxc", "qxh", "qxl", "qxn", "qxo", "qxp",
			"qxq", "qxr", "qxs", "qxt", "qxu", "qxw", "qya", "qyp"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_R = new HashSet<>(Arrays.asList("raa", "rab", "rac", "rad", "raf", "rag",
			"rah", "rai", "raj", "rak", "ral", "ram", "ran", "rao", "rap", "raq", "rar", "ras", "rat", "rau", "rav",
			"raw", "rax", "ray", "raz", "rbb", "rbk", "rbl", "rbp", "rcf", "rdb", "rea", "reb", "ree", "reg", "rei",
			"rej", "rel", "rem", "ren", "rer", "res", "ret", "rey", "rga", "rge", "rgk", "rgn", "rgr", "rgs", "rgu",
			"rhg", "rhp", "ria", "rif", "ril", "rim", "rin", "rir", "rit", "riu", "rjg", "rji", "rjs", "rka", "rkb",
			"rkh", "rki", "rkm", "rkt", "rkw", "rm", "rma", "rmb", "rmc", "rmd", "rme", "rmf", "rmg", "rmh", "rmi",
			"rmk", "rml", "rmm", "rmn", "rmo", "rmp", "rmq", "rms", "rmt", "rmu", "rmv", "rmw", "rmx", "rmy", "rmz",
			"rn", "rnd", "rng", "rnl", "rnn", "rnp", "rnr", "rnw", "ro", "rob", "roc", "rod", "roe", "rof", "rog",
			"roh", "rol", "rom", "ron", "roo", "rop", "ror", "rou", "row", "rpn", "rpt", "rri", "rro", "rrt", "rsb",
			"rsl", "rsm", "rtc", "rth", "rtm", "rts", "rtw", "ru", "rub", "ruc", "rue", "ruf", "rug", "ruh", "rui",
			"ruk", "run", "ruo", "rup", "ruq", "rus", "rut", "ruu", "ruy", "ruz", "rw", "rwa", "rwk", "rwm", "rwo",
			"rwr", "rxd", "rxw", "ryn", "rys", "ryu", "rzh"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_S = new HashSet<>(Arrays.asList("sa", "saa", "sab", "sac", "sad", "sae",
			"saf", "sag", "sah", "saj", "sak", "sam", "san", "sao", "saq", "sar", "sas", "sat", "sau", "sav", "saw",
			"sax", "say", "saz", "sba", "sbb", "sbc", "sbd", "sbe", "sbf", "sbg", "sbh", "sbi", "sbj", "sbk", "sbl",
			"sbm", "sbn", "sbo", "sbp", "sbq", "sbr", "sbs", "sbt", "sbu", "sbv", "sbw", "sbx", "sby", "sbz", "sc",
			"scb", "sce", "scf", "scg", "sch", "sci", "sck", "scl", "scn", "sco", "scp", "scq", "scs", "sct", "scu",
			"scv", "scw", "scx", "sd", "sda", "sdb", "sdc", "sde", "sdf", "sdg", "sdh", "sdj", "sdk", "sdl", "sdm",
			"sdn", "sdo", "sdp", "sdr", "sds", "sdt", "sdu", "sdx", "sdz", "se", "sea", "seb", "sec", "sed", "see",
			"sef", "seg", "seh", "sei", "sej", "sek", "sel", "sen", "seo", "sep", "seq", "ser", "ses", "set", "seu",
			"sev", "sew", "sey", "sez", "sfb", "sfe", "sfm", "sfs", "sfw", "sg", "sga", "sgb", "sgc", "sgd", "sge",
			"sgg", "sgh", "sgi", "sgj", "sgk", "sgm", "sgp", "sgr", "sgs", "sgt", "sgu", "sgw", "sgx", "sgy", "sgz",
			"sha", "shb", "shc", "shd", "she", "shg", "shh", "shi", "shj", "shk", "shl", "shm", "shn", "sho", "shp",
			"shq", "shr", "shs", "sht", "shu", "shv", "shw", "shx", "shy", "shz", "si", "sia", "sib", "sid", "sie",
			"sif", "sig", "sih", "sii", "sij", "sik", "sil", "sim", "sin", "sip", "siq", "sir", "sis", "siu", "siv",
			"siw", "six", "siy", "siz", "sja", "sjb", "sjd", "sje", "sjg", "sjk", "sjl", "sjm", "sjn", "sjo", "sjp",
			"sjr", "sjs", "sjt", "sju", "sjw", "sk", "ska", "skb", "skc", "skd", "ske", "skf", "skg", "skh", "ski",
			"skj", "skm", "skn", "sko", "skp", "skq", "skr", "sks", "skt", "sku", "skv", "skw", "skx", "sky", "skz",
			"sl", "slc", "sld", "sle", "slf", "slg", "slh", "sli", "slj", "slk", "sll", "slm", "sln", "slp", "slq",
			"slr", "sls", "slt", "slu", "slv", "slw", "slx", "sly", "slz", "sm", "sma", "smb", "smc", "smd", "sme",
			"smf", "smg", "smh", "smj", "smk", "sml", "smm", "smn", "smo", "smp", "smq", "smr", "sms", "smt", "smu",
			"smv", "smw", "smx", "smy", "smz", "sn", "sna", "snb", "snc", "snd", "sne", "snf", "sng", "sni", "snj",
			"snk", "snl", "snm", "snn", "sno", "snp", "snq", "snr", "sns", "snu", "snv", "snw", "snx", "sny", "snz",
			"so", "soa", "sob", "soc", "sod", "soe", "sog", "soh", "soi", "soj", "sok", "sol", "som", "soo", "sop",
			"soq", "sor", "sos", "sot", "sou", "sov", "sow", "sox", "soy", "soz", "spa", "spb", "spc", "spd", "spe",
			"spg", "spi", "spk", "spl", "spm", "spn", "spo", "spp", "spq", "spr", "sps", "spt", "spu", "spv", "spx",
			"spy", "sq", "sqa", "sqh", "sqi", "sqk", "sqm", "sqn", "sqo", "sqq", "sqr", "sqs", "sqt", "squ", "sr",
			"sra", "srb", "src", "srd", "sre", "srf", "srg", "srh", "sri", "srk", "srl", "srm", "srn", "sro", "srp",
			"srq", "srr", "srs", "srt", "sru", "srv", "srw", "srx", "sry", "srz", "ss", "ssb", "ssc", "ssd", "sse",
			"ssf", "ssg", "ssh", "ssi", "ssj", "ssk", "ssl", "ssm", "ssn", "sso", "ssp", "ssq", "ssr", "sss", "sst",
			"ssu", "ssv", "ssw", "ssx", "ssy", "ssz", "st", "sta", "stb", "std", "ste", "stf", "stg", "sth", "sti",
			"stj", "stk", "stl", "stm", "stn", "sto", "stp", "stq", "str", "sts", "stt", "stu", "stv", "stw", "sty",
			"su", "sua", "sub", "suc", "sue", "sug", "sui", "suj", "suk", "sun", "suq", "sur", "sus", "sut", "suv",
			"suw", "sux", "suy", "suz", "sv", "sva", "svb", "svc", "sve", "svk", "svm", "svs", "svx", "sw", "swa",
			"swb", "swc", "swe", "swf", "swg", "swh", "swi", "swj", "swk", "swl", "swm", "swn", "swo", "swp", "swq",
			"swr", "sws", "swt", "swu", "swv", "sww", "swx", "swy", "sxb", "sxc", "sxe", "sxg", "sxk", "sxl", "sxm",
			"sxn", "sxo", "sxr", "sxs", "sxu", "sxw", "sya", "syb", "syc", "syi", "syk", "syl", "sym", "syn", "syo",
			"syr", "sys", "syw", "syx", "syy", "sza", "szb", "szc", "szd", "sze", "szg", "szl", "szn", "szp", "szs",
			"szv", "szw"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_T = new HashSet<>(Arrays.asList("ta", "taa", "tab", "tac", "tad", "tae",
			"taf", "tag", "tah", "taj", "tak", "tal", "tam", "tan", "tao", "tap", "taq", "tar", "tas", "tat", "tau",
			"tav", "taw", "tax", "tay", "taz", "tba", "tbb", "tbc", "tbd", "tbe", "tbf", "tbg", "tbh", "tbi", "tbj",
			"tbk", "tbl", "tbm", "tbn", "tbo", "tbp", "tbr", "tbs", "tbt", "tbu", "tbv", "tbw", "tbx", "tby", "tbz",
			"tca", "tcb", "tcc", "tcd", "tce", "tcf", "tcg", "tch", "tci", "tck", "tcl", "tcm", "tcn", "tco", "tcp",
			"tcq", "tcs", "tct", "tcu", "tcw", "tcx", "tcy", "tcz", "tda", "tdb", "tdc", "tdd", "tde", "tdf", "tdg",
			"tdh", "tdi", "tdj", "tdk", "tdl", "tdm", "tdn", "tdo", "tdq", "tdr", "tds", "tdt", "tdv", "tdx", "tdy",
			"te", "tea", "teb", "tec", "ted", "tee", "tef", "teg", "teh", "tei", "tek", "tel", "tem", "ten", "teo",
			"tep", "teq", "ter", "tes", "tet", "teu", "tev", "tew", "tex", "tey", "tfi", "tfn", "tfo", "tfr", "tft",
			"tg", "tga", "tgb", "tgc", "tgd", "tge", "tgf", "tgh", "tgi", "tgj", "tgk", "tgl", "tgn", "tgo", "tgp",
			"tgq", "tgr", "tgs", "tgt", "tgu", "tgv", "tgw", "tgx", "tgy", "tgz", "th", "tha", "thd", "the", "thf",
			"thh", "thi", "thk", "thl", "thm", "thn", "thp", "thq", "thr", "ths", "tht", "thu", "thv", "thw", "thy",
			"thz", "ti", "tia", "tic", "tif", "tig", "tih", "tii", "tij", "tik", "til", "tim", "tin", "tio", "tip",
			"tiq", "tir", "tis", "tit", "tiu", "tiv", "tiw", "tix", "tiy", "tiz", "tja", "tjg", "tji", "tjl", "tjm",
			"tjn", "tjo", "tjs", "tju", "tjw", "tk", "tka", "tkb", "tkd", "tke", "tkf", "tkg", "tkl", "tkm", "tkn",
			"tkp", "tkq", "tkr", "tks", "tkt", "tku", "tkv", "tkw", "tkx", "tkz", "tl", "tla", "tlb", "tlc", "tld",
			"tlf", "tlg", "tlh", "tli", "tlj", "tlk", "tll", "tlm", "tln", "tlo", "tlp", "tlq", "tlr", "tls", "tlt",
			"tlu", "tlv", "tlx", "tly", "tma", "tmb", "tmc", "tmd", "tme", "tmf", "tmg", "tmh", "tmi", "tmj", "tmk",
			"tml", "tmm", "tmn", "tmo", "tmq", "tmr", "tms", "tmt", "tmu", "tmv", "tmw", "tmy", "tmz", "tn", "tna",
			"tnb", "tnc", "tnd", "tng", "tnh", "tni", "tnk", "tnl", "tnm", "tnn", "tno", "tnp", "tnq", "tnr", "tns",
			"tnt", "tnu", "tnv", "tnw", "tnx", "tny", "tnz", "to", "tob", "toc", "tod", "tof", "tog", "toh", "toi",
			"toj", "tol", "tom", "ton", "too", "top", "toq", "tor", "tos", "tou", "tov", "tow", "tox", "toy", "toz",
			"tpa", "tpc", "tpe", "tpf", "tpg", "tpi", "tpj", "tpk", "tpl", "tpm", "tpn", "tpo", "tpp", "tpq", "tpr",
			"tpt", "tpu", "tpv", "tpw", "tpx", "tpy", "tpz", "tqb", "tql", "tqm", "tqn", "tqo", "tqp", "tqq", "tqr",
			"tqt", "tqu", "tqw", "tr", "tra", "trb", "trc", "trd", "tre", "trf", "trg", "trh", "tri", "trj", "trl",
			"trm", "trn", "tro", "trp", "trq", "trr", "trs", "trt", "tru", "trv", "trw", "trx", "try", "trz", "ts",
			"tsa", "tsb", "tsc", "tsd", "tse", "tsg", "tsh", "tsi", "tsj", "tsk", "tsl", "tsm", "tsn", "tso", "tsp",
			"tsq", "tsr", "tss", "tst", "tsu", "tsv", "tsw", "tsx", "tsy", "tsz", "tt", "tta", "ttb", "ttc", "ttd",
			"tte", "ttf", "ttg", "tth", "tti", "ttj", "ttk", "ttl", "ttm", "ttn", "tto", "ttp", "ttq", "ttr", "tts",
			"ttt", "ttu", "ttv", "ttw", "tty", "ttz", "tua", "tub", "tuc", "tud", "tue", "tuf", "tug", "tuh", "tui",
			"tuj", "tuk", "tul", "tum", "tun", "tuo", "tuq", "tur", "tus", "tuu", "tuv", "tux", "tuy", "tuz", "tva",
			"tvd", "tve", "tvk", "tvl", "tvm", "tvn", "tvo", "tvs", "tvt", "tvu", "tvw", "tvy", "tw", "twa", "twb",
			"twc", "twd", "twe", "twf", "twg", "twh", "twi", "twl", "twm", "twn", "two", "twp", "twq", "twr", "twt",
			"twu", "tww", "twx", "twy", "txa", "txb", "txc", "txe", "txg", "txh", "txi", "txj", "txm", "txn", "txo",
			"txq", "txr", "txs", "txt", "txu", "txx", "txy", "ty", "tya", "tye", "tyh", "tyi", "tyj", "tyl", "tyn",
			"typ", "tyr", "tys", "tyt", "tyu", "tyv", "tyx", "tyz", "tza", "tzh", "tzj", "tzl", "tzm", "tzn", "tzo",
			"tzx"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_U = new HashSet<>(Arrays.asList("uam", "uan", "uar", "uba", "ubi", "ubl",
			"ubr", "ubu", "uby", "uda", "ude", "udg", "udi", "udj", "udl", "udm", "udu", "ues", "ufi", "ug", "uga",
			"ugb", "uge", "ugn", "ugo", "ugy", "uha", "uhn", "uig", "uis", "uiv", "uji", "uk", "uka", "ukg", "ukh",
			"ukk", "ukl", "ukp", "ukq", "ukr", "uks", "uku", "ukw", "uky", "ula", "ulb", "ulc", "ule", "ulf", "uli",
			"ulk", "ull", "ulm", "uln", "ulu", "ulw", "uma", "umb", "umc", "umd", "umg", "umi", "umm", "umn", "umo",
			"ump", "umr", "ums", "umu", "una", "und", "une", "ung", "unk", "unm", "unn", "unr", "unu", "unx", "unz",
			"upi", "upv", "ur", "ura", "urb", "urc", "urd", "ure", "urf", "urg", "urh", "uri", "urk", "url", "urm",
			"urn", "uro", "urp", "urr", "urt", "uru", "urv", "urw", "urx", "ury", "urz", "usa", "ush", "usi", "usk",
			"usp", "usu", "uta", "ute", "utp", "utr", "utu", "uum", "uun", "uur", "uuu", "uve", "uvh", "uvl", "uwa",
			"uya", "uz", "uzb", "uzn", "uzs"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_V = new HashSet<>(Arrays.asList("vaa", "vae", "vaf", "vag", "vah", "vai",
			"vaj", "val", "vam", "van", "vao", "vap", "var", "vas", "vau", "vav", "vay", "vbb", "vbk", "ve", "vec",
			"ved", "vel", "vem", "ven", "veo", "vep", "ver", "vgr", "vgt", "vi", "vic", "vid", "vie", "vif", "vig",
			"vil", "vin", "vis", "vit", "viv", "vka", "vki", "vkj", "vkk", "vkl", "vkm", "vko", "vkp", "vkt", "vku",
			"vlp", "vls", "vma", "vmb", "vmc", "vmd", "vme", "vmf", "vmg", "vmh", "vmi", "vmj", "vmk", "vml", "vmm",
			"vmp", "vmq", "vmr", "vms", "vmu", "vmv", "vmw", "vmx", "vmy", "vmz", "vnk", "vnm", "vnp", "vo", "vol",
			"vor", "vot", "vra", "vro", "vrs", "vrt", "vsi", "vsl", "vsv", "vto", "vum", "vun", "vut", "vwa"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_W = new HashSet<>(Arrays.asList("wa", "waa", "wab", "wac", "wad", "wae",
			"waf", "wag", "wah", "wai", "waj", "wal", "wam", "wan", "wao", "wap", "waq", "war", "was", "wat", "wau",
			"wav", "waw", "wax", "way", "waz", "wba", "wbb", "wbe", "wbf", "wbh", "wbi", "wbj", "wbk", "wbl", "wbm",
			"wbp", "wbq", "wbr", "wbs", "wbt", "wbv", "wbw", "wca", "wci", "wdd", "wdg", "wdj", "wdk", "wdu", "wdy",
			"wea", "wec", "wed", "weg", "weh", "wei", "wem", "weo", "wep", "wer", "wes", "wet", "weu", "wew", "wfg",
			"wga", "wgb", "wgg", "wgi", "wgo", "wgu", "wgy", "wha", "whg", "whk", "whu", "wib", "wic", "wie", "wif",
			"wig", "wih", "wii", "wij", "wik", "wil", "wim", "win", "wir", "wiu", "wiv", "wiy", "wja", "wji", "wka",
			"wkb", "wkd", "wkl", "wku", "wkw", "wky", "wla", "wlc", "wle", "wlg", "wli", "wlk", "wll", "wlm", "wln",
			"wlo", "wlr", "wls", "wlu", "wlv", "wlw", "wlx", "wly", "wma", "wmb", "wmc", "wmd", "wme", "wmh", "wmi",
			"wmm", "wmn", "wmo", "wms", "wmt", "wmw", "wmx", "wnb", "wnc", "wnd", "wne", "wng", "wni", "wnk", "wnm",
			"wnn", "wno", "wnp", "wnu", "wnw", "wny", "wo", "woa", "wob", "woc", "wod", "woe", "wof", "wog", "woi",
			"wok", "wol", "wom", "won", "woo", "wor", "wos", "wow", "woy", "wpc", "wra", "wrb", "wrd", "wrg", "wrh",
			"wri", "wrk", "wrl", "wrm", "wrn", "wro", "wrp", "wrr", "wrs", "wru", "wrv", "wrw", "wrx", "wry", "wrz",
			"wsa", "wsg", "wsi", "wsk", "wsr", "wss", "wsu", "wsv", "wtf", "wth", "wti", "wtk", "wtm", "wtw", "wua",
			"wub", "wud", "wuh", "wul", "wum", "wun", "wur", "wut", "wuu", "wuv", "wux", "wuy", "wwa", "wwb", "wwo",
			"wwr", "www", "wxa", "wxw", "wya", "wyb", "wyi", "wym", "wyr", "wyy"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_X = new HashSet<>(Arrays.asList("xaa", "xab", "xac", "xad", "xae", "xag",
			"xai", "xaj", "xak", "xal", "xam", "xan", "xao", "xap", "xaq", "xar", "xas", "xat", "xau", "xav", "xaw",
			"xay", "xbb", "xbc", "xbd", "xbe", "xbg", "xbi", "xbj", "xbm", "xbn", "xbo", "xbp", "xbr", "xbw", "xby",
			"xcb", "xcc", "xce", "xcg", "xch", "xcl", "xcm", "xcn", "xco", "xcr", "xct", "xcu", "xcv", "xcw", "xcy",
			"xda", "xdc", "xdk", "xdm", "xdo", "xdy", "xeb", "xed", "xeg", "xel", "xem", "xep", "xer", "xes", "xet",
			"xeu", "xfa", "xga", "xgb", "xgd", "xgf", "xgg", "xgi", "xgl", "xgm", "xgr", "xgu", "xgw", "xh", "xha",
			"xhc", "xhd", "xhe", "xho", "xhr", "xht", "xhu", "xhv", "xib", "xii", "xil", "xin", "xir", "xis", "xiv",
			"xiy", "xjb", "xjt", "xka", "xkb", "xkc", "xkd", "xke", "xkf", "xkg", "xki", "xkj", "xkk", "xkl", "xkn",
			"xko", "xkp", "xkq", "xkr", "xks", "xkt", "xku", "xkv", "xkw", "xkx", "xky", "xkz", "xla", "xlb", "xlc",
			"xld", "xle", "xlg", "xli", "xln", "xlo", "xlp", "xls", "xlu", "xly", "xma", "xmb", "xmc", "xmd", "xme",
			"xmf", "xmg", "xmh", "xmj", "xmk", "xml", "xmm", "xmn", "xmo", "xmp", "xmq", "xmr", "xms", "xmt", "xmu",
			"xmv", "xmw", "xmx", "xmy", "xmz", "xna", "xnb", "xng", "xnh", "xni", "xnk", "xnn", "xno", "xnr", "xns",
			"xnt", "xnu", "xny", "xnz", "xoc", "xod", "xog", "xoi", "xok", "xom", "xon", "xoo", "xop", "xor", "xow",
			"xpa", "xpc", "xpe", "xpg", "xpi", "xpj", "xpk", "xpm", "xpn", "xpo", "xpp", "xpq", "xpr", "xps", "xpt",
			"xpu", "xpy", "xqa", "xqt", "xra", "xrb", "xrd", "xre", "xrg", "xri", "xrm", "xrn", "xrq", "xrr", "xrt",
			"xru", "xrw", "xsa", "xsb", "xsc", "xsd", "xse", "xsh", "xsi", "xsl", "xsm", "xsn", "xso", "xsp", "xsq",
			"xsr", "xss", "xsu", "xsv", "xsy", "xta", "xtb", "xtc", "xtd", "xte", "xtg", "xth", "xti", "xtj", "xtl",
			"xtm", "xtn", "xto", "xtp", "xtq", "xtr", "xts", "xtt", "xtu", "xtv", "xtw", "xty", "xtz", "xua", "xub",
			"xud", "xug", "xuj", "xul", "xum", "xun", "xuo", "xup", "xur", "xut", "xuu", "xve", "xvi", "xvn", "xvo",
			"xvs", "xwa", "xwc", "xwd", "xwe", "xwg", "xwj", "xwk", "xwl", "xwo", "xwr", "xwt", "xww", "xxb", "xxk",
			"xxm", "xxr", "xxt", "xya", "xyb", "xyj", "xyk", "xyl", "xyt", "xyy", "xzh", "xzm", "xzp"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_Y = new HashSet<>(Arrays.asList("yaa", "yab", "yac", "yad", "yae", "yaf",
			"yag", "yah", "yai", "yaj", "yak", "yal", "yam", "yan", "yao", "yap", "yaq", "yar", "yas", "yat", "yau",
			"yav", "yaw", "yax", "yay", "yaz", "yba", "ybb", "ybe", "ybh", "ybi", "ybj", "ybk", "ybl", "ybm", "ybn",
			"ybo", "ybx", "yby", "ych", "ycl", "ycn", "ycp", "yda", "ydd", "yde", "ydg", "ydk", "yea", "yec", "yee",
			"yei", "yej", "yel", "yer", "yes", "yet", "yeu", "yev", "yey", "yga", "ygi", "ygl", "ygm", "ygp", "ygr",
			"ygs", "ygu", "ygw", "yha", "yhd", "yhl", "yhs", "yi", "yia", "yid", "yif", "yig", "yih", "yii", "yij",
			"yik", "yil", "yim", "yin", "yip", "yiq", "yir", "yis", "yit", "yiu", "yiv", "yix", "yiz", "yka", "ykg",
			"yki", "ykk", "ykl", "ykm", "ykn", "yko", "ykr", "ykt", "yku", "yky", "yla", "ylb", "yle", "ylg", "yli",
			"yll", "ylm", "yln", "ylo", "ylr", "ylu", "yly", "ymb", "ymc", "ymd", "yme", "ymg", "ymh", "ymi", "ymk",
			"yml", "ymm", "ymn", "ymo", "ymp", "ymq", "ymr", "yms", "ymx", "ymz", "yna", "ynd", "yne", "yng", "ynk",
			"ynl", "ynn", "yno", "ynq", "yns", "ynu", "yo", "yob", "yog", "yoi", "yok", "yol", "yom", "yon", "yor",
			"yot", "yox", "yoy", "ypa", "ypb", "ypg", "yph", "ypm", "ypn", "ypo", "ypp", "ypz", "yra", "yrb", "yre",
			"yrk", "yrl", "yrm", "yrn", "yro", "yrs", "yrw", "yry", "ysc", "ysd", "ysg", "ysl", "ysn", "yso", "ysp",
			"ysr", "yss", "ysy", "yta", "ytl", "ytp", "ytw", "yty", "yua", "yub", "yuc", "yud", "yue", "yuf", "yug",
			"yui", "yuj", "yuk", "yul", "yum", "yun", "yup", "yuq", "yur", "yut", "yuw", "yux", "yuy", "yuz", "yva",
			"yvt", "ywa", "ywg", "ywl", "ywn", "ywq", "ywr", "ywt", "ywu", "yww", "yxa", "yxg", "yxl", "yxm", "yxu",
			"yxy", "yyr", "yyu", "yyz", "yzg", "yzk"));
	
	/**
	 * Constant set of valid languages starting with letter *_{LETTER_IN_VARIABLE_NAME}*.
	 * Must be public as it is accessed using reflection.
	 */
	public final static Set<String> LANGUAGES_Z = new HashSet<>(Arrays.asList("za", "zaa", "zab", "zac", "zad", "zae",
			"zaf", "zag", "zah", "zai", "zaj", "zak", "zal", "zam", "zao", "zap", "zaq", "zar", "zas", "zat", "zau",
			"zav", "zaw", "zax", "zay", "zaz", "zbc", "zbe", "zbl", "zbt", "zbw", "zca", "zch", "zdj", "zea", "zeg",
			"zeh", "zen", "zga", "zgb", "zgh", "zgm", "zgn", "zgr", "zh", "zha", "zhb", "zhd", "zhi", "zhn", "zho",
			"zhw", "zia", "zib", "zik", "zil", "zim", "zin", "zir", "ziw", "ziz", "zka", "zkb", "zkd", "zkg", "zkh",
			"zkk", "zkn", "zko", "zkp", "zkr", "zkt", "zku", "zkv", "zkz", "zlj", "zlm", "zln", "zlq", "zma", "zmb",
			"zmc", "zmd", "zme", "zmf", "zmg", "zmh", "zmi", "zmj", "zmk", "zml", "zmm", "zmn", "zmo", "zmp", "zmq",
			"zmr", "zms", "zmt", "zmu", "zmv", "zmw", "zmx", "zmy", "zmz", "zna", "zne", "zng", "znk", "zns", "zoc",
			"zoh", "zom", "zoo", "zoq", "zor", "zos", "zpa", "zpb", "zpc", "zpd", "zpe", "zpf", "zpg", "zph", "zpi",
			"zpj", "zpk", "zpl", "zpm", "zpn", "zpo", "zpp", "zpq", "zpr", "zps", "zpt", "zpu", "zpv", "zpw", "zpx",
			"zpy", "zpz", "zqe", "zra", "zrg", "zrn", "zro", "zrp", "zrs", "zsa", "zsk", "zsl", "zsm", "zsr", "zsu",
			"zte", "ztg", "ztl", "ztm", "ztn", "ztp", "ztq", "zts", "ztt", "ztu", "ztx", "zty", "zu", "zua", "zuh",
			"zul", "zum", "zun", "zuy", "zwa", "zxx", "zyb", "zyg", "zyj", "zyn", "zyp", "zza", "zzj"));

}
