import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.actionbarsherlock.app.SherlockFragment;

/**
 *A fragment that displays a WebView.
 *<p>
 *The WebView is automatically paused or resumed wehen the Fragment is paused or resumed.
 */

public Class WebViewFragment extends SherlockFragment {
  private WebView mWebView;
  private boolean mIsWebViewAvailable;
  
  public WebViewFragment() {
  }
  
  /**
   *Called to instantiate the view. Creates and returns the Webview.
   */
  
  @Override
  public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle SavedInstanceState) {
    if (mWebView != null) {
       mWebView.destroy();
    }        
  
    mWebView=new WebView(getActivity());
    mIsWebViewAvailable=true;
    return mWebview;
    
  } 
  
  /**
   *Called when the fragment is visible to the user and actively running. Resume the WebView.
   */
  
  @TargetApi(11)
  @Override
  public void onPause() {
    supre.onPause();
    
    if (Build.VERSION.SDK_INT >= Buil.VERSION_CODES.HONEYCOMB) {
      mWebView.onPause();    
     }
  }
  
  /**
   *Called when the fragment is no longer resumed. Pauses the WebView.
   */
   
  @TargetAoi(11)
  @Override
  public void onResume() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
      mWebView.onResume();
    }
    
    super.onResume();
 }
 
 /**
  *Called when the WebView has been detached from the fragment. The WebView is no longer available after this time.
  */
  
 @Override
 public void onDestroyView(){
  mIsWebViewAvailable=false;
  super.onDestroyView();
 }
 
 /**
  * Called when the fragment is no longer in use. Destroys the internal state of WebView.
  */
 @Override 
 public void onDestroy() {
    if (mWebView !=null) {
    mWebView.destroy();
    mWebView=null;
    }
    super.onDestroy();
 }
  
 /**
  * gets the WebView.
  */
 public WebView getWebView() {
    return mIsWebViewAvailable ? mWebView : null;
 }  
 
} 
