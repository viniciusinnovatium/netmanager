//*****************************************************************************
//** TASC - ALPHALINC - MAC VARProdutoEtq
//** Innovatium Systems - Code Converter - v1.30
//** 2014-06-26 19:29:45
//*****************************************************************************

import mLibrary.*;

//<< #include COMSYS
import include.COMSYS;
import include.COMSYSDate;
import include.COMSYSNum;
import include.COMSYSString;
import include.COMSYSWWW;
import include.COMSYSOutput;
import include.COMSYSEnum;
import include.COMGridEdit31Interface;
import include.COMTab;
import include.COMEditor;
import include.COMSYSJS;
import include.$occInclude;

//<< VARProdutoEtq
public class VARProdutoEtq extends mClass {

  public void main() {
    _VARProdutoEtq();
  }

  public void _VARProdutoEtq() {
  }

  //<< 
  //<< OnBeforeFormConstruction(YKEY,YPARA)
  public Object OnBeforeFormConstruction(Object ... _p) {
    mVar YKEY = m$.newVarRef("YKEY",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar YPARA = m$.newVarRef("YPARA",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< 
    //<< if ( (YKEY '= "") && (YPARA '= "") ) {
    if (mOp.Logical(((mOp.NotEqual(YKEY.get(),"")) && (mOp.NotEqual(YPARA.get(),""))))) {
      //<< kill ^VARTempProdutoEtq(YM,YBED)
      m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get()).kill();
      //<< set $piece(^VARTempProdutoEtq(YM,YBED,1),Y,1) = YKEY
      m$.pieceVar(m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get(),1),m$.var("Y").get(),1).set(YKEY.get());
    }
    //<< }
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< OnAfterSave
  public void OnAfterSave() {
    //<< new Item, pLote, pValidade
    mVar Item = m$.var("Item");
    mVar pLote = m$.var("pLote");
    mVar pValidade = m$.var("pValidade");
    m$.newVar(Item,pLote,pValidade);
    //<< set Item      = $get(VORG(1))
    Item.set(m$.Fnc.$get(m$.var("VORG").var(1)));
    //<< set pLote     = $get(VORG(2))
    pLote.set(m$.Fnc.$get(m$.var("VORG").var(2)));
    //<< set pValidade = $get(VORG(3))
    pValidade.set(m$.Fnc.$get(m$.var("VORG").var(3)));
    //<< set pMarca    = $get(VORG(4))
    mVar pMarca = m$.var("pMarca");
    pMarca.set(m$.Fnc.$get(m$.var("VORG").var(4)));
    //<< 
    //<< set $piece(^VARTempProdutoEtq(YM,YBED,1),Y,1) = Item
    m$.pieceVar(m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get(),1),m$.var("Y").get(),1).set(Item.get());
    //<< set $piece(^VARTempProdutoEtq(YM,YBED,1),Y,2) = pLote
    m$.pieceVar(m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get(),1),m$.var("Y").get(),2).set(pLote.get());
    //<< set $piece(^VARTempProdutoEtq(YM,YBED,1),Y,3) = pValidade
    m$.pieceVar(m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get(),1),m$.var("Y").get(),3).set(pValidade.get());
    //<< set $piece(^VARTempProdutoEtq(YM,YBED,1),Y,4) = pMarca
    m$.pieceVar(m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get(),1),m$.var("Y").get(),4).set(pMarca.get());
    //<< do GoToForm^COMUtilForm("VARProdutoEtq",Item,,,,,)
    m$.Cmd.Do("COMUtilForm.GoToForm","VARProdutoEtq",Item.get(),null,null,null,null,null);
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< OnAfterDataFields
  public void OnAfterDataFields() {
    //<< 
    //<< do MontaGrid
    m$.Cmd.Do("MontaGrid");
    //<< 
    //<< quit
    return;
  }

  //<< 
  //<< MontaGrid
  public Object MontaGrid() {
    //<< quit:($get(VORG(1)) = "")
    if ((mOp.Equal(m$.Fnc.$get(m$.var("VORG").var(1)),""))) {
      return null;
    }
    //<< 
    //<< new idItem, strDescItem, local, qtd, lote, validade, pLote, pValidade
    mVar idItem = m$.var("idItem");
    mVar strDescItem = m$.var("strDescItem");
    mVar local = m$.var("local");
    mVar qtd = m$.var("qtd");
    mVar lote = m$.var("lote");
    mVar validade = m$.var("validade");
    mVar pLote = m$.var("pLote");
    mVar pValidade = m$.var("pValidade");
    m$.newVar(idItem,strDescItem,local,qtd,lote,validade,pLote,pValidade);
    //<< 
    //<< set qtd         = 0
    qtd.set(0);
    //<< set idItem      = $get(VORG(1))
    idItem.set(m$.Fnc.$get(m$.var("VORG").var(1)));
    //<< set pLote       = $piece($get(^VARTempProdutoEtq(YM,YBED,1)),Y,2)
    pLote.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),2));
    //<< set pValidade   = $piece($get(^VARTempProdutoEtq(YM,YBED,1)),Y,3)
    pValidade.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),3));
    //<< set pMarca      = $piece($get(^VARTempProdutoEtq(YM,YBED,1)),Y,4)
    mVar pMarca = m$.var("pMarca");
    pMarca.set(m$.Fnc.$piece(m$.Fnc.$get(m$.var("^VARTempProdutoEtq",m$.var("YM").get(),m$.var("YBED").get(),1)),m$.var("Y").get(),4));
    //<< set strDescItem = $$SQLGetDescricaoProduto^VARTRKSQL(idItem)
    strDescItem.set(m$.fnc$("VARTRKSQL.SQLGetDescricaoProduto",idItem.get()));
    //<< set pLocal      = YLOCATION
    mVar pLocal = m$.var("pLocal");
    pLocal.set(m$.var("YLOCATION").get());
    //<< 
    //<< Set ProdEtq = ##class(%ResultSet).%New()
    mVar ProdEtq = m$.var("ProdEtq");
    ProdEtq.set(m$.fnc$("$ResultSet.$New"));
    //<< 
    //<< new meuSQL
    mVar meuSQL = m$.var("meuSQL");
    m$.newVar(meuSQL);
    //<< set meuSQL = ""
    meuSQL.set("");
    //<< 
    //<< set meuSQL = "SELECT "
    meuSQL.set("SELECT ");
    //<< set meuSQL = meuSQL_" Item, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Item, "));
    //<< set meuSQL = meuSQL_" Storage->Location, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Storage->Location, "));
    //<< set meuSQL = meuSQL_" QtyOnHand, "
    meuSQL.set(mOp.Concat(meuSQL.get()," QtyOnHand, "));
    //<< set meuSQL = meuSQL_" Bundle->LotNumber, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Bundle->LotNumber, "));
    //<< set meuSQL = meuSQL_" Bundle->UseByDate, "
    meuSQL.set(mOp.Concat(meuSQL.get()," Bundle->UseByDate, "));
    //<< set meuSQL = meuSQL_" $$GetBrandName^VARSQL(Bundle->Brand) as Brand "
    meuSQL.set(mOp.Concat(meuSQL.get()," $$GetBrandName^VARSQL(Bundle->Brand) as Brand "));
    //<< set meuSQL = meuSQL_" FROM alSOH.dBundleStock "
    meuSQL.set(mOp.Concat(meuSQL.get()," FROM alSOH.dBundleStock "));
    //<< set meuSQL = meuSQL_" WHERE Storage->Location = '"_pLocal_"'"
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," WHERE Storage->Location = '"),pLocal.get()),"'"));
    //<< set meuSQL = meuSQL_" AND Item = '"_idItem_"'"
    meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND Item = '"),idItem.get()),"'"));
    //<< if (pLote'=""){
    if ((mOp.NotEqual(pLote.get(),""))) {
      //<< set meuSQL = meuSQL_" AND Bundle->LotNumber = '"_pLote_"'"
      meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND Bundle->LotNumber = '"),pLote.get()),"'"));
    }
    //<< }
    //<< if (pValidade'=""){
    if ((mOp.NotEqual(pValidade.get(),""))) {
      //<< set meuSQL = meuSQL_" AND Bundle->UseByDate = '"_pValidade_"'"
      meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND Bundle->UseByDate = '"),pValidade.get()),"'"));
    }
    //<< }
    //<< if (pMarca'=""){
    if ((mOp.NotEqual(pMarca.get(),""))) {
      //<< set meuSQL = meuSQL_" AND Bundle->Brand = '"_pMarca_"'"
      meuSQL.set(mOp.Concat(mOp.Concat(mOp.Concat(meuSQL.get()," AND Bundle->Brand = '"),pMarca.get()),"'"));
    }
    //<< }
    //<< 
    //<< Do ProdEtq.Prepare(meuSQL)
    m$.Cmd.Do(ProdEtq.getORef(),"Prepare",meuSQL.get());
    //<< Do ProdEtq.Execute()
    m$.Cmd.Do(ProdEtq.getORef(),"Execute");
    //<< 
    //<< //Tabela
    //<< new lstHeader
    mVar lstHeader = m$.var("lstHeader");
    m$.newVar(lstHeader);
    //<< set lstHeader = ""
    lstHeader.set("");
    //<< set lstHeader = lstHeader_$listbuild("Cod. Produto","Descrição", "Lote", "Validade","Marca","Quantidade em Estoque","Cod. Barras")
    lstHeader.set(mOp.Concat(lstHeader.get(),m$.Fnc.$listbuild("Cod. Produto","Descrição","Lote","Validade","Marca","Quantidade em Estoque","Cod. Barras")));
    //<< 
    //<< if $$Start^COMTable(lstHeader) {
    if (mOp.Logical(m$.fnc$("COMTable.Start",lstHeader.get()))) {
      //<< 
      //<< While (ProdEtq.Next()) {
      while (mOp.Logical((m$.fnc$(ProdEtq.getORef(),"Next")))) {
        //<< 
        //<< set Item       = ProdEtq.GetData(1)
        mVar Item = m$.var("Item");
        Item.set(m$.fnc$(ProdEtq.getORef(),"GetData",1));
        //<< set Local      = ProdEtq.GetData(2)
        mVar Local = m$.var("Local");
        Local.set(m$.fnc$(ProdEtq.getORef(),"GetData",2));
        //<< set Quantidade = ProdEtq.GetData(3)
        mVar Quantidade = m$.var("Quantidade");
        Quantidade.set(m$.fnc$(ProdEtq.getORef(),"GetData",3));
        //<< set Lote       = ProdEtq.GetData(4)
        mVar Lote = m$.var("Lote");
        Lote.set(m$.fnc$(ProdEtq.getORef(),"GetData",4));
        //<< set UseByDate  = ProdEtq.GetData(5)
        mVar UseByDate = m$.var("UseByDate");
        UseByDate.set(m$.fnc$(ProdEtq.getORef(),"GetData",5));
        //<< set Marca      = ProdEtq.GetData(6)
        mVar Marca = m$.var("Marca");
        Marca.set(m$.fnc$(ProdEtq.getORef(),"GetData",6));
        //<< 
        //<< set qtd = $increment(qtd)
        qtd.set(m$.Fnc.$increment(qtd));
        //<< 
        //<< set Validade = $$SQLGetDataFormatada^VARSQL(UseByDate)
        mVar Validade = m$.var("Validade");
        Validade.set(m$.fnc$("VARSQL.SQLGetDataFormatada",UseByDate.get()));
        //<< 
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< 
        //<< do InsertCell^COMTable(idItem)
        m$.Cmd.Do("COMTable.InsertCell",idItem.get());
        //<< do InsertCell^COMTable(strDescItem)
        m$.Cmd.Do("COMTable.InsertCell",strDescItem.get());
        //<< do InsertCell^COMTable(Lote)
        m$.Cmd.Do("COMTable.InsertCell",Lote.get());
        //<< do InsertCell^COMTable(Validade)
        m$.Cmd.Do("COMTable.InsertCell",Validade.get());
        //<< do InsertCell^COMTable(Marca)
        m$.Cmd.Do("COMTable.InsertCell",Marca.get());
        //<< do InsertCell^COMTable(Quantidade)
        m$.Cmd.Do("COMTable.InsertCell",Quantidade.get());
        //<< do InsertCellCallback^COMTable("Imprimir","Imprimir^VARProdutoEtq",""_idItem_","_Lote_"")
        m$.Cmd.Do("COMTable.InsertCellCallback","Imprimir","Imprimir^VARProdutoEtq",mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat("",idItem.get()),","),Lote.get()),""));
        //<< 
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< 
      //<< 
      //<< }
      //<< if 'qtd {
      if (mOp.Not(qtd.get())) {
        //<< do NewLine^COMTable()
        m$.Cmd.Do("COMTable.NewLine");
        //<< do InsertCell^COMTable("Não existe código de barras cadastrado para esse produto",,,,,,7)
        m$.Cmd.Do("COMTable.InsertCell","Não existe código de barras cadastrado para esse produto",null,null,null,null,null,7);
        //<< do EndLine^COMTable()
        m$.Cmd.Do("COMTable.EndLine");
      }
      //<< }
      //<< 
      //<< do Stop^COMTable()
      m$.Cmd.Do("COMTable.Stop");
    }
    //<< 
    //<< }
    //<< 
    //<< do ProdEtq.Close()
    m$.Cmd.Do(ProdEtq.getORef(),"Close");
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< CanPrint()
  public Object CanPrint() {
    //<< set YQ = $$$YQEnable
    mVar YQ = m$.var("YQ");
    YQ.set(include.COMSYSWWW.$$$YQEnable(m$));
    //<< if (YKEY'=""){
    if ((mOp.NotEqual(m$.var("YKEY").get(),""))) {
      //<< set VORG(1) = YKEY
      mVar VORG = m$.var("VORG");
      VORG.var(1).set(m$.var("YKEY").get());
    }
    //<< }elseif (YPARA'=""){
    else if ((mOp.NotEqual(m$.var("YPARA").get(),""))) {
      //<< set VORG(1) = YPARA
      mVar VORG = m$.var("VORG");
      VORG.var(1).set(m$.var("YPARA").get());
    }
    //<< }
    //<< if ($get(VORG(1)) = ""){
    if ((mOp.Equal(m$.Fnc.$get(m$.var("VORG").var(1)),""))) {
      //<< set YQ = $$$YQDisable("Selecione um produto")
      YQ.set(include.COMSYSWWW.$$$YQDisable(m$,"Selecione um produto"));
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< ;if ($data(^INARTUPC1(0,$get(VORG(1))))=0){
    //<< ;   set YQ = $$$YQDisable("Não existe código de barras cadastrado para esse produto")
    //<< ;   quit
    //<< ;}
    //<< 
    //<< quit
    return null;
  }

  //<< 
  //<< Imprimir(idItem,Lote)
  public Object Imprimir(Object ... _p) {
    mVar idItem = m$.newVarRef("idItem",(((_p!=null)&&(_p.length>=1))?_p[0]:null));
    mVar Lote = m$.newVarRef("Lote",(((_p!=null)&&(_p.length>=2))?_p[1]:null));
    //<< ;set Filtro = $get(VORG(1))
    //<< 
    //<< if idItem = "" {
    if (mOp.Equal(idItem.get(),"")) {
      //<< quit
      return null;
    }
    //<< }
    //<< 
    //<< do RunReportProdutoEtq^VARJasperRunReport(idItem,Lote)
    m$.Cmd.Do("VARJasperRunReport.RunReportProdutoEtq",idItem.get(),Lote.get());
    //<< 
    //<< quit
    return null;
  }

//<< 
}
