import groovy.xml.XmlUtil

class MainXMLParser {

    static void main(String[] args) {

      def xmlfilePath = "/Users/vignesh/Desktop/test.xml"

      def xml = new XmlParser().parse(xmlfilePath)

      //pages[0] is outer tag, page is inner tag, pageType is child of inner
      <!--EG
          <pages>
            <page>
              <pageType>DESKTOP</pageType>
            </page>
            <page>
              <pageType>MOBILE</pageType>
            </page>
          </pages>
        -->
        //If the pagType is DESKTOP, the below code will change in to MOBILE and update the given xml file.

        xml.pages[0].page.each {
            ob -> ob.pageType[0].text().equals("DESKTOP")
        }.each {
            ob -> ob.pageType[0].value = "MOBILE"
        }
        XmlUtil xmlUtil = new XmlUtil()
        xmlUtil.serialize(xml, new FileWriter(xmlfilePath))
    }
}
