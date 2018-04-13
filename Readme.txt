1.org.archive.crawler
序号	类	说明
1	CommandLineParser	Heritrix也可以通过CMD命令进行操作,该类用于解析CMD命令
2	Heritrix	Heritrix主类,可以通过该类启动Heritrix
3	SimpleHttpServer	Heritrix Web服务器,可以通过Web管理Heritrix
4	WebappLifecycle	封装Servlet,如此才可以通过Web启动Heritrix,里面装载Heritrix对象
 
2.org.archive.crawler.admin
序号	 类	 说明
1	 CrawlJob	 Heritrix的核心类,代表着一个抓取任务,order.xml中大部分属性都围绕其配置,以后会着重说明
2	 CrawlJobErrorHandler	 维护者一个抓取任务(CrawlJob)的错误日志,UI中显示的JOB错误就来自于它
3	 CrawlJobHandler	 抓取任务处理器,Heritrix可以有多个抓取任务,都由它进行管理
4	 InvalidJobFileException	 抓取任务文件异常,意义不大
5	 SeedRecord	 记录种子的处理记录,如该种子重定向到哪个URL,在seeds.txt里面会有说明，该重定向值就来源于它
6	 StatisticsSummary	 统计摘要类，所用不多
7	 StatisticsTracker	 Heritrix核心类，统计跟踪器,贯穿整个Heritrix的运行,如统计抓取了多少URL，以后会着重说明
 
 
3.org.archive.crawler.admin.ui
序号	类	说明
1	CookieUtils	Cookie工具类,主要用于访问Cookie
2	JobConfigureUtils	CrawlJob配置管理工具类,当你通过Web Ui去配置一个CrawlJob时就会用到这个类
3	RootFilter	不熟
 
 
4.org.archive.crawler.datamodel
序号	类	说明
1	CandidateURI	Heritrix的核心类,代表着一个URL,贯穿整个抓取,与CrawlURI的区别是它还没有通过调度器(Frontier)，只有通过了调度器的URL才可能去获取网页内容区下载等，以后会着重说明
2	CandidateURITest	CandidateURI的测试类,比如可以用它获知如何创建CanditeURI
3	Checkpoint	Heritrix会定期备份它的数据,如日志、正在获取的URL内容，都是在底层定时运行,当Heritrix异常中断可以通过它来恢复.也类似于各个数据库的Ckeckpoint
4	CoreAttributeConstants	装载着Heritrix的基本属性变量名,一般是对应order.xml中的标签名
5	CrawlHost	Heiritrix的核心类,代表着一个Host，里面主要包含域名、IP。由于Heritrix可以控制抓取速度，如对一个Host的抓取速度,这个类就代表着那个Host.以后会着重说明
6	CrawlOrder	Heritrix的核心类,基本上对应着order.xml的各个属性值,除了各个组件的详细属性，以后会着重说明
7	CrawlServer	Heritrix的核心类,也对应着一个Host,里面装载着一个Host的各种Heritrix数据,如统计信息、爬虫协议
8	CrawlSubstats	抓取统计类,主要统计抓取Url的个数、成功的个数、下载的字节数等等
9	CrawlURI	CandidateURI的子类,主要比CaidiateURI多了网页内容指纹、所属队列、组件处理器等
10	 CredentialStore	 凭证存储类，负责存储各种凭证,如登陆
11	 FetchStatusCodes	 抓取状态,有不同的属性代表不同的抓取状态,如DNS获取成功：S_DNS_SUCCESS
12	 RobotsHonoringPolicy	 爬虫协议,代表着不同的抓取策略
13	 Robotstxt	 爬虫协议,用于解析robots.txt
14	 ServerCache	 服务器缓存,主要缓存CrawlHost和CrawlServer
15	UriUniqFilter	接口,用于过滤已经抓取过的URL
 
 
5.org.archive.crawler.datamodel.credential
序号	类	说明
1	Credential	凭证类,代表着一个凭证,从order.xml配置文件中获取数据
2	CredentialAvatar	代表着一个具体的凭证
3	HtmlFormCredential	Credential的子类,代表着提交HTML FORM表单时所需要的凭证
4	Rfc2617Credential	Credential的子类,代表着RFC2617 HTTP 认证凭证
 
 
6.org.archive.crawler.deciderules
序号	类	说明
1	AcceptDecideRule	URL规则,表示接受
2	ConfiguredDecideRule	URL规则，通过order.xml文件中的配置来决定是否拒绝(REJECT)或接受(ACCEPT)
3	DecideRule	URL规则的父类,审核一个URL是否接受(ACCEPT)、拒绝(REJECT)或放弃(PASS),通过decisionFor(Object object)方法,该方法由其子类实现
4	 DecidingScope	 验证一个URL是否在范围来决定是否接受、拒绝或放弃
5	 MatchesRegExpDecideRule	 通过配置的正则表达式来决定URL是否可接受、拒绝或放弃
6	 NotMatchesRegExpDecideRule	 MatchesRegExpDecideRule的子类,如果URL不匹配该正则则接受
7	 PathologicalPathDecideRule	 如果URL中相同目录名超过配置文件中的个数,则拒绝,如http://www.xxx.com/a/a/a/a/a其中a的个数超过一定限制则拒绝
8	 PrerequisiteAcceptDecideRule	 如果URL中有先决条件URL则接受,也就是该CandidateURI里的pathFromSeed属性里含有P,表示运行该URL之前有先要运行的URL
9	 RejectDecideRule	 URL规则，表示拒绝
10	 TooManyHopsDecideRule	 如果超过配置文件中的约点数(max-hops),则拒绝
 
 
7.org.archive.crawler.event
序号	类	说明
1	CrawlStatusListener	爬虫监听器,如监听爬虫是否在运行，是否暂停等
2	CrawlURIDispositionListener	URL监听器,如监听URL是否失败，是要要重新抓取等
 
 
8.org.archive.crawler.extractor
序号	类	说明
1	Extractor	所有抽取类的父类,用于从一个URL中抽取出新的URL
2	ExtractorCSS	从CSS中抽取出新的URL
3	ExtractorDOC	从DOC中抽取出新的URL
4	ExtractorHTML	从HTML中抽取出新的URL,Heritrix核心类
5	ExtractorHTTP	从HTTP中抽取出新的URL
6	ExtractorJS	从Javascript中抽取出新的URL
7	ExtractorPDF	从PDF中抽取出新的URL
8	ExtractorSWF	从SWF中抽取出新的URL
9	ExtractorXML	从XML中抽取出新的URL
10	HTTPContentDigest	网页内容文摘,实际上是通过MD5或SHA1算法将网页内容指纹化
11	Link	链接,代表抽取出来的URL
