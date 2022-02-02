<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="xml"
doctype-public="-//W3C//DTD HTML 4.01//EN"
doctype-system="http://www.w3.org/TR/html4/strict.dtd"/>

<xsl:template match="/">
<html>
<head>
    <meta charset='utf-8'/>
    <title>Médiathèque de Champs sur Marne</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'/>
    <style>
        th {
    background-color: #000080;
    color: #FFFFFF;
}
td {
    background-color: #BEBEBEFF;
    color:#080648;
}
    </style>
</head>
<body>
    <table style="width:100%;">
        <tr>
            <th>Ref</th>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Genre</th>
        </tr>
       <xsl:apply-templates select="/cdtheque/cd"/>
      </table>
</body>
</html>
  
</xsl:template>

<xsl:template match="cd">
<tr>
<td><xsl:value-of select="reference" /></td>
<td><xsl:value-of select="titre" /></td>
<td><xsl:value-of select="auteur" /></td>
<td><xsl:value-of select="genre" /></td>
</tr>
</xsl:template>

</xsl:stylesheet>