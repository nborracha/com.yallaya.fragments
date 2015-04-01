/* C++ code produced by gperf version 3.0.3 */
/* Command-line: /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/gperf -L C++ -E -t /private/var/folders/tc/q63jm69s6t9bkn6k8vw6nm4c0000gn/T/Nimrod/fragments-generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/private/var/folders/tc/q63jm69s6t9bkn6k8vw6nm4c0000gn/T/Nimrod/fragments-generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "com.yallaya.fragments.FragmentFrameProxy.h"
#include "com.yallaya.fragments.FragmentProxy.h"
#include "com.yallaya.fragments.FragmentsModule.h"


#line 15 "/private/var/folders/tc/q63jm69s6t9bkn6k8vw6nm4c0000gn/T/Nimrod/fragments-generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 6, duplicates = 0 */

class FragmentsBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
FragmentsBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct titanium::bindings::BindEntry *
FragmentsBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 3,
      MIN_WORD_LENGTH = 35,
      MAX_WORD_LENGTH = 40,
      MIN_HASH_VALUE = 35,
      MAX_HASH_VALUE = 40
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
#line 18 "/private/var/folders/tc/q63jm69s6t9bkn6k8vw6nm4c0000gn/T/Nimrod/fragments-generated/KrollGeneratedBindings.gperf"
      {"com.yallaya.fragments.FragmentProxy", ::com::yallaya::fragments::fragments::FragmentProxy::bindProxy, ::com::yallaya::fragments::fragments::FragmentProxy::dispose},
      {""},
#line 19 "/private/var/folders/tc/q63jm69s6t9bkn6k8vw6nm4c0000gn/T/Nimrod/fragments-generated/KrollGeneratedBindings.gperf"
      {"com.yallaya.fragments.FragmentsModule", ::com::yallaya::fragments::FragmentsModule::bindProxy, ::com::yallaya::fragments::FragmentsModule::dispose},
      {""}, {""},
#line 17 "/private/var/folders/tc/q63jm69s6t9bkn6k8vw6nm4c0000gn/T/Nimrod/fragments-generated/KrollGeneratedBindings.gperf"
      {"com.yallaya.fragments.FragmentFrameProxy", ::com::yallaya::fragments::fragments::FragmentFrameProxy::bindProxy, ::com::yallaya::fragments::fragments::FragmentFrameProxy::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      unsigned int key = hash (str, len);

      if (key <= MAX_HASH_VALUE)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 20 "/private/var/folders/tc/q63jm69s6t9bkn6k8vw6nm4c0000gn/T/Nimrod/fragments-generated/KrollGeneratedBindings.gperf"

