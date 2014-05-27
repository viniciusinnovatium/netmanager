//*****************************************************************************
//** TASC - ALPHALINC - MAC WWWTRAIL
//** Innovatium Systems - Code Converter - v1.27
//** 2014-05-22 00:15:06
//*****************************************************************************

import mLibrary.*;


//<< WWWTRAIL
public class WWWTRAIL extends mClass {

  public Object main() {
    _WWWTRAIL();
    return null;
  }

  public Object _WWWTRAIL() {
    //<< ;-------------------------------------------------------------------------------
    //<< ; Description of Function :
    //<< ;       MOUSETRAIL EINGESCHALTET
    //<< ;
    //<< ; Inputs :
    //<< ;
    //<< ;
    //<< ; ByRef :
    //<< ;
    //<< ;
    //<< ; Returns :
    //<< ;
    //<< ;
    //<< ; History :
    //<< ; 28.07.1999    DT      Created
    //<< ;-------------------------------------------------------------------------------
    //<< QUIT
    return null;
  }

  //<< 
  //<< SCRIPT ;TEXT IN HAEDER ;Text within
  public void SCRIPT() {
    //<< NEW YI
    mVar YI = m$.var("YI");
    m$.newVar(YI);
    //<< FOR YI=1:1:60 SET YI(1) = $TEXT(SCRIPT1+YI) DO
    for (YI.set(1);(mOp.LessOrEqual(YI.get(),60));YI.set(mOp.Add(YI.get(),1))) {
      YI.var(1).set(m$.Fnc.$text(mOp.Add(m$.var("SCRIPT1").get(),YI.get())));
      //<< . SET YI(1)=$PIECE(YI(1),";",2,999)
      YI.var(1).set(m$.Fnc.$piece(YI.var(1).get(),";",2,999));
      //<< . IF $FIND(YI(1),"src = '") SET YI(1)=$PIECE(YI(1),"src = '",1)_"src = '"_YGIF_$PIECE(YI(1),"src = '",2,99)
      if (mOp.Logical(m$.Fnc.$find(YI.var(1).get(),"src = '"))) {
        YI.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YI.var(1).get(),"src = '",1),"src = '"),m$.var("YGIF").get()),m$.Fnc.$piece(YI.var(1).get(),"src = '",2,99)));
      }
      //<< . WRITE YCR,YI(1)
      m$.Cmd.Write(m$.var("YCR").get(),YI.var(1).get());
    }
    SCRIPT1();
  }

  //<< ;QUIT
  //<< 
  //<< ; FIXME : Why explicit drop through? - appear to doesn't add anything
  //<< 
  //<< SCRIPT1 ;
  public Object SCRIPT1() {
    //<< ;<SCRIPT LANGUAGE="JavaScript">
    //<< ;//tmtC_Mousetrail
    //<< ;var isNS = (navigator.appName == "Netscape");
    //<< ;layerRef = (isNS) ? "document" : "document.all";
    //<< ;styleRef = (isNS) ? "" : ".style";
    //<< ;var queue = new Array();
    //<< ;var NUM_OF_TRAIL_PARTS = 5
    //<< ;for (x=1; x < 6; x++) {
    //<< ;eval("trailSpriteFrame" + x + " = new Image(20,20);");
    //<< ;eval("trailSpriteFrame" + x + ".src = 'docu.gif';");}
    //<< ;
    //<< ;function trailSpriteObj(anID) {
    //<< ;       this.trailSpriteID = "trailSprite" + anID;
    //<< ;       this.imgRef = "trailSprite" + anID + "img";
    //<< ;       this.currentFrame = 1;
    //<< ;       this.animateTrailSprite = animateTrailSprite;}
    //<< ;
    //<< ;function animateTrailSprite() {
    //<< ;       if (this.currentFrame <6 ) {
    //<< ;       if (isNS) {
    //<< ;       eval("document." + this.trailSpriteID +".document['" + this.imgRef + "'].src=trailSpriteFrame" + this.currentFrame + ".src");
    //<< ;} else {
    //<< ;       eval("document['" + this.imgRef + "'].src  =  trailSpriteFrame" + this.currentFrame + ".src");}
    //<< ;       this.currentFrame ++;
    //<< ;       } else {
    //<< ;       eval(layerRef + '.' + this.trailSpriteID +  styleRef + '.visibility = "hidden"');}}
    //<< ;
    //<< ;function processAnim() {
    //<< ;       for(x=1; x < NUM_OF_TRAIL_PARTS; x++)
    //<< ;       queue[x].animateTrailSprite();}
    //<< ;
    //<< ;function processMouse(e) {
    //<< ;       currentObj = shuffleQueue();
    //<< ;       if (isNS) {
    //<< ;       eval("document." + currentObj + ".left = e.pageX - 10 ;");
    //<< ;       eval("document." + currentObj + ".top = e.pageY + 10;");
    //<< ;       } else {
    //<< ;       eval("document.all." + currentObj + ".style.pixelLeft = event.clientX + document.body.scrollLeft - 10 ;");
    //<< ;       eval("document.all." + currentObj + ".style.pixelTop = event.clientY + document.body.scrollTop + 10 ;");}}
    //<< ;
    //<< ;function shuffleQueue() {
    //<< ;       lastItemPos = queue.length - 1;
    //<< ;       lastItem = queue[lastItemPos];
    //<< ;       for (i = lastItemPos; i>0; i--)
    //<< ;       queue[i] = queue[i-1];
    //<< ;       queue[0] = lastItem;
    //<< ;       queue[0].currentFrame = 1;
    //<< ;       eval(layerRef + '.' + queue[0].trailSpriteID +  styleRef + '.visibility = "visible"');
    //<< ;       return queue[0].trailSpriteID;}
    //<< ;
    //<< ;function init() {
    //<< ;       for(x=0; x<NUM_OF_TRAIL_PARTS; x++)
    //<< ;       queue[x] = new trailSpriteObj(x+1) ;
    //<< ;       if (isNS) { document.captureEvents(Event.MOUSEMOVE); }
    //<< ;       document.onmousemove = processMouse;
    //<< ;       setInterval("processAnim();",30);}
    //<< ;       window.onload = init;
    //<< ;</SCRIPT>
    //<< ;
    //<< ;
    //<< ;
    //<< ;
    //<< QUIT
    return null;
  }

  //<< 
  //<< BODY ;TEXT IN BODY ;Text within
  public void BODY() {
    //<< NEW YI
    mVar YI = m$.var("YI");
    m$.newVar(YI);
    //<< FOR YI=1:1:12 SET YI(1)=$TEXT(BODY1+YI) QUIT:$PIECE(YI(1),";",2)=";"  DO
    for (YI.set(1);(mOp.LessOrEqual(YI.get(),12));YI.set(mOp.Add(YI.get(),1))) {
      YI.var(1).set(m$.Fnc.$text(mOp.Add(m$.var("BODY1").get(),YI.get())));
      if (mOp.Equal(m$.Fnc.$piece(YI.var(1).get(),";",2),";")) {
        break;
      }
      //<< . SET YI(1)=$PIECE(YI(1),";",2,999)
      YI.var(1).set(m$.Fnc.$piece(YI.var(1).get(),";",2,999));
      //<< . IF $FIND(YI(1),"src="_"""") SET YI(1)=$PIECE(YI(1),"src="_"""",1)_"src="_""""_YGIF_$PIECE(YI(1),"src="_"""",2,99)
      if (mOp.Logical(m$.Fnc.$find(YI.var(1).get(),mOp.Concat("src=","\"")))) {
        YI.var(1).set(mOp.Concat(mOp.Concat(mOp.Concat(mOp.Concat(m$.Fnc.$piece(YI.var(1).get(),mOp.Concat("src=","\""),1),"src="),"\""),m$.var("YGIF").get()),m$.Fnc.$piece(YI.var(1).get(),mOp.Concat("src=","\""),2,99)));
      }
      //<< . WRITE YCR,YI(1)
      m$.Cmd.Write(m$.var("YCR").get(),YI.var(1).get());
    }
    BODY1();
  }

  //<< ;QUIT
  //<< 
  //<< ; FIXME : Why explicit drop through? - doesn't appear to add anything
  //<< 
  //<< BODY1 ;
  public Object BODY1() {
    //<< ;<!--tmtC_Mousetrail-->
    //<< ;<DIV id="trailSprite1" style="position: absolute; height:20px; width:20px;z-index: 10">
    //<< ;<IMG src="docu.gif" height=20 width=20 border=0 name="trailSprite1img"> </DIV>
    //<< ;<DIV id="trailSprite2" style="position: absolute; height:20px; width:20px;z-index: 10">
    //<< ;<IMG src="docu.gif" height=20 width=20 border=0 name="trailSprite2img"> </DIV>
    //<< ;<DIV id="trailSprite3" style="position: absolute; height:20px; width:20px;z-index: 10">
    //<< ;<IMG src="docu.gif" height=20 width=20 border=0 name="trailSprite3img"> </DIV>
    //<< ;<DIV id="trailSprite4" style="position: absolute; height:20px; width:20px;z-index: 10">
    //<< ;<IMG src="docu.gif" height=20 width=20 border=0 name="trailSprite4img"> </DIV>
    //<< ;<DIV id="trailSprite5" style="position: absolute; height:20px; width:20px;z-index: 10">
    //<< ;<IMG src="docu.gif" height=20 width=20 border=0 name="trailSprite5img"> </DIV>
    //<< ;<!--End tmtC_Mousetrail-->
    //<< ;
    //<< ;
    //<< ;
    //<< ;
    //<< ;
    //<< QUIT
    return null;
  }

//<< 
}
